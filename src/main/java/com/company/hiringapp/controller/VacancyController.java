package com.company.hiringapp.controller;

import com.company.hiringapp.dto.*;
import com.company.hiringapp.entity.VacancyStatus;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import static com.company.hiringapp.controller.ControllerHelper.*;


@Controller
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private UserService userService;
    @Autowired
    private JobTypeService jobTypeService;
    @Autowired
    private CityService cityService;
    @Autowired
    private SkillService skillService;
    @Autowired
    private CurrencyService currencyService;
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private RecruiterService recruiterService;
    @Autowired
    private VacancySkillService vacancySkillService;
    @Autowired
    private LevelService levelService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private EmailService emailService;

    @GetMapping("/vacancies")
    public ModelAndView getAll(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        HashMap<VacancyDTO, List<VacancySkillDTO>> vacancies = new HashMap<>();
        for (VacancyDTO vacancy : vacancyService.findAll()) {
            vacancies.put(vacancy, vacancySkillService.findByVacancy(vacancy));
        }

        if (principal != null) {
            UserDTO userDTO = userService.findByUsername(principal.getName());
            modelAndView.addObject("user", userDTO);
        }
        modelAndView.setViewName("vacancy/vacancies");
//        modelAndView.addObject("skillSet", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));
        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("vacancyFilterForm", new VacancyFilterClass());
        modelAndView.addObject("jobTypes", jobTypeService.findAll());
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("skills", skillService.findAll());
        modelAndView.addObject("currencies", currencyService.findAll());
        modelAndView.addObject("companies", companyService.findAll());

        return modelAndView;
    }


    @GetMapping("/vacancies/vacancyDetail/{id}")
    public String vacancyDetail(Model model, @PathVariable(name = "id") Long id, Principal principal) {

        VacancyDTO vacancyDTO = vacancyService.findById(id);
        List<VacancySkillDTO> vacancySkillDTOList = vacancySkillService.findByVacancy(vacancyDTO);
        model.addAttribute("vacancySkillsList", vacancySkillDTOList);
        model.addAttribute("vacancy", vacancyDTO);
        if (principal != null) {
            model.addAttribute("user", userService.findByUsername(principal.getName()));
            if (vacancyDTO.getResponses().size() != 0) {
                for (UserDTO response : vacancyDTO.getResponses()) {
                    System.out.println(response.getUsername());
                }
            } else {
                System.out.println("???????????????? ????????");
            }
        } else model.addAttribute("user", new UserDTO());

        return "/vacancy/vacancyDetail";
    }

    @PreAuthorize("hasRole('ROLE_HR')")
    @GetMapping("/vacancies/{id}/changeStatus")
    public String changeVacancyStatus(@PathVariable(name = "id") Long id,
                                      @RequestParam(required = false) String open,
                                      @RequestParam(required = false) String pause,
                                      @RequestParam(required = false) String cancel,
                                      @RequestParam(required = false) String close) {

        VacancyDTO vacancyDTO = vacancyService.findById(id);
        if (Objects.nonNull(open)) {
            vacancyDTO.setStatus(VacancyStatus.OPEN);
        }
        if (Objects.nonNull(pause)) {
            vacancyDTO.setStatus(VacancyStatus.PAUSE);
        }
        if (Objects.nonNull(cancel)) {
            vacancyDTO.setStatus(VacancyStatus.CANCELED);
        }
        if (Objects.nonNull(close)) {
            vacancyDTO.setStatus(VacancyStatus.CLOSED);
        }

//        vacancyService.update(vacancyDTO);
        vacancyService.save(vacancyDTO);


        String subjectTemplate = "VacancyService77: ???????????????? %s ???????????????? ????????????";
        String textTemplate = "???????????? ???????? %s %s!\n\n???????????????? %s, ???? ?????????????? ???? ????????????????????????, ???????????????? ???????????? ????: %s\nHR-????????????????????: %s %s, %s\n";


        String subject = String.format(subjectTemplate, vacancyDTO.getPosition());

        for (UserDTO user : vacancyDTO.getResponses()) {
            String text = String.format(textTemplate, user.getFirstName(), user.getLastName(),
                    vacancyDTO.getPosition(), vacancyDTO.getStatus().name(),
                    vacancyDTO.getRecruiter().getUser().getFirstName(), vacancyDTO.getRecruiter().getUser().getLastName(),
                    vacancyDTO.getRecruiter().getCompany().getName());

            emailService.sendSimpleMessage(user.getEmail(), subject, text);
        }


        return redirectTo("vacancies/vacancyDetail/" + id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/vacancies/{id}/subscribe")
    public String subscribe(@PathVariable(name = "id") Long id,
                            Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.addResponse(id, userDTO);

        return redirectTo("vacancies/vacancyDetail/" + id);
    }

    @PreAuthorize("isAuthenticated()")
    @RequestMapping("/vacancies/{id}/unsubscribe")
    public String unsubscribe(@PathVariable(name = "id") Long id,
                              Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.removeResponse(id, userDTO);

        return redirectTo("vacancies/vacancyDetail/" + id);
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/vacancies/myResponses")
    public ModelAndView myResponses(Principal principal,
                                    @Validated @ModelAttribute("vacancyFilterForm") VacancyFilterClass dto) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/vacancies");
        UserDTO user = userService.findByUsername(principal.getName());
        HashMap<VacancyDTO, List<VacancySkillDTO>> vacancies = new HashMap<>();
        for (VacancyDTO vacancy : vacancyService.myResponses(user)) {
            vacancies.put(vacancy, vacancySkillService.findByVacancy(vacancy));
        }
        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/myVacancies")
    public ModelAndView myVacancies(Principal principal,
                                    @Validated @ModelAttribute("vacancyFilterForm") VacancyFilterClass dto) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/vacancies");
        UserDTO user = userService.findByUsername(principal.getName());
        RecruiterDTO recruiterDTO = recruiterService.findByUser(user);
        HashMap<VacancyDTO, List<VacancySkillDTO>> vacancies = new HashMap<>();
        for (VacancyDTO vacancy : vacancyService.findByRecruiter(recruiterDTO)) {
            vacancies.put(vacancy, vacancySkillService.findByVacancy(vacancy));
        }


        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("user", user);

        return modelAndView;
    }


    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/addVacancy")
    public ModelAndView addVacancy(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/addVacancyForm");
        UserDTO user = userService.findByUsername(principal.getName());

        modelAndView.addObject("vacancyForm", new VacancyDTO());
        modelAndView.addObject("jobTypes", jobTypeService.findAll());
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("currencies", currencyService.findAll());
//        modelAndView.addObject("skills", skillService.findAll());

        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @PostMapping("/vacancies/addVacancy")
    public String addVacancy(Model model,
                             @Validated @ModelAttribute("vacancyForm") VacancyDTO vacancyDTO,
                             BindingResult bindingResult,
                             Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        RecruiterDTO recruiterDTO = recruiterService.findByUser(userDTO);
        vacancyDTO.setRecruiter(recruiterDTO);
        vacancyDTO.setCreateDate(LocalDate.now());
        vacancyDTO.setStatus(VacancyStatus.OPEN);
        vacancyService.save(vacancyDTO);

        return redirectTo("vacancies/vacancyDetail/" + vacancyService.findAll().get(vacancyService.findAll().size() - 1).getId());
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/{id}/addSkill")
    public ModelAndView addSkill(Principal principal,
                                 @PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView();

        VacancyDTO vacancy = vacancyService.findById(id);
        VacancySkillDTO vacancySkillDTO = new VacancySkillDTO();
        vacancySkillDTO.setVacancy(vacancy);
        modelAndView.setViewName("vacancy/chooseSkill");

        modelAndView.addObject("vacancySkillForm", vacancySkillDTO);
        modelAndView.addObject("skills", skillService.findAll());
        modelAndView.addObject("levels", levelService.findAll());

        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @PostMapping("/vacancies/{id}/addSkill")
    public String addSkill(Model model,
                           @PathVariable Long id,
                           @Validated @ModelAttribute("vacancySkillForm") VacancySkillDTO vacancySkillDTO,
                           BindingResult bindingResult,
                           Principal principal) {
        VacancyDTO vacancy = vacancyService.findById(id);
        vacancySkillDTO.setVacancy(vacancy);
        vacancySkillService.save(vacancySkillDTO);
        return redirectTo("vacancies/vacancyDetail/" + id);
    }


    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/delete/{id}")
    public String delete(@PathVariable Long id, Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        VacancyDTO vacancyDTO = vacancyService.findById(id);

        vacancyService.delete(vacancyDTO);
        return redirectTo("vacancies");
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/responses/{id}")
    public ModelAndView responses(@PathVariable Long id, Principal principal) {

        ModelAndView modelAndView = new ModelAndView();

        VacancyDTO vacancyDTO = vacancyService.findById(id);

        modelAndView.setViewName("vacancy/responses");

        List<ResumeDTO> responsesResume = new ArrayList<>();

        for (UserDTO user : vacancyDTO.getResponses()) {
            responsesResume.add(resumeService.findByUser(user));
        }


        modelAndView.addObject("users", vacancyDTO.getResponses());
        modelAndView.addObject("resumes", responsesResume);

        return modelAndView;
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/skills/add")
    public ModelAndView addSkill() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("skillForm", new SkillDTO());
        modelAndView.setViewName("vacancy/addSkill");

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/skills/add")
    public String addSkill(Model model,
                           @Validated @ModelAttribute("skillForm") SkillDTO dto,
                           BindingResult result,
                           Principal principal) {
        if (checkBindingResult(result)) {
            model.addAttribute("skillForm", dto);
            return "vacancy/addSkill";
        }

        try {

            skillService.save(dto);
        } catch (ServiceException e) {
            model.addAttribute("message", e.getMessage());
            return goBackTo("vacancy/addSkill");
        }

        return redirectTo("vacancies/addVacancy");
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/cities/add")
    public ModelAndView addCity() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("cityForm", new CityDTO());
        modelAndView.setViewName("vacancy/addCity");

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/cities/add")
    public String addCity(Model model,
                          @Validated @ModelAttribute("cityForm") CityDTO dto,
                          BindingResult result,
                          Principal principal) {
        if (checkBindingResult(result)) {
            model.addAttribute("cityForm", dto);
            return "vacancy/addCity";
        }

        try {

            cityService.save(dto);
        } catch (ServiceException e) {
            model.addAttribute("message", e.getMessage());
            return goBackTo("vacancy/addCity");
        }

        return redirectTo("vacancies/addVacancy");
    }

    @PostMapping("/vacancies/filter")
    public ModelAndView filter(Model model,
                               @Validated @ModelAttribute("vacancyFilterForm") VacancyFilterClass dto,
                               BindingResult result,
                               Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        HashMap<VacancyDTO, List<VacancySkillDTO>> vacancies = new HashMap<>();
        for (VacancyDTO vacancy : vacancyService.filter(dto)) {
            vacancies.put(vacancy, vacancySkillService.findByVacancy(vacancy));
        }

        if (principal != null) {
            UserDTO userDTO = userService.findByUsername(principal.getName());
            modelAndView.addObject("user", userDTO);
        }
        modelAndView.setViewName("vacancy/vacancies");
//        modelAndView.addObject("skillSet", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));
        modelAndView.addObject("vacancies", vacancies);
        modelAndView.addObject("vacancyFilterForm", new VacancyFilterClass());
        modelAndView.addObject("jobTypes", jobTypeService.findAll());
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("skills", skillService.findAll());
        modelAndView.addObject("currencies", currencyService.findAll());
        modelAndView.addObject("companies", companyService.findAll());

        return modelAndView;
    }

}
