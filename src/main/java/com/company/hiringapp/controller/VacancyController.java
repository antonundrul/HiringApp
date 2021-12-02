package com.company.hiringapp.controller;

import com.company.hiringapp.dto.MessageDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillSetDTO;
import com.company.hiringapp.service.UserService;
import com.company.hiringapp.service.VacancyService;
import com.company.hiringapp.service.VacancySkillSetService;
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
import java.util.List;

import static com.company.hiringapp.controller.ControllerHelper.redirectTo;


@Controller
//@RequestMapping("/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private VacancySkillSetService vacancySkillSetService;
    @Autowired
    private UserService userService;

    @GetMapping("/vacancies")
    public ModelAndView getAll(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();


        if(principal!=null) {
            UserDTO userDTO = userService.findByUsername(principal.getName());
            modelAndView.addObject("user", userDTO);
        }
        modelAndView.setViewName("vacancy/vacancies");
//        modelAndView.addObject("skillSet", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));
        modelAndView.addObject("vacancies", vacancyService.findAll());

        return modelAndView;
    }


    @GetMapping("/vacancies/vacancyDetail/{id}")
    public String vacancyDetail(Model model, @PathVariable(name = "id") Long id,Principal principal) {

        VacancyDTO vacancyDTO = vacancyService.findById(id);
        List<VacancySkillSetDTO> vacancySkillSetDTOList = vacancySkillSetService.findByResume(vacancyDTO);

        model.addAttribute("vacancy", vacancyDTO);
//        model.addAttribute("skillList", vacancySkillSetDTOList);
        if (principal != null) {
            model.addAttribute("user", userService.findByUsername(principal.getName()));
            if(vacancyDTO.getResponses().size()!=0) {
                for (UserDTO response:vacancyDTO.getResponses()) {
                    System.out.println(response.getUsername());
                }
            }
            else{
                System.out.println("Откликов нету");
            }
        }

        else model.addAttribute("user", new UserDTO());

        return "/vacancy/vacancyDetail";
    }

    @RequestMapping("/vacancies/vacancyDetail/{id}/subscribe")
    public String subscribe(@PathVariable(name = "id") Long id,
                            Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.addResponse(id, userDTO);

        return redirectTo("vacancies/vacancyDetail/"+id);
    }

    @RequestMapping("/vacancies/vacancyDetail/{id}/unsubscribe")
    public String unsubscribe(@PathVariable(name = "id") Long id,
                              Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.removeResponse(id, userDTO);

        return redirectTo("vacancies");
    }

    @GetMapping("/vacancies/myResponses")
    public ModelAndView myResponses(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/vacancies");
        UserDTO user = userService.findByUsername(principal.getName());

//        modelAndView.addObject("skillSet", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));
        modelAndView.addObject("vacancies", vacancyService.myResponses(user));
        modelAndView.addObject("user", user);

        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @GetMapping("/vacancies/myVacancies")
    public ModelAndView myVacancies(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/vacancies");
        UserDTO user = userService.findByUsername(principal.getName());

//        modelAndView.addObject("skillSet", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));
        modelAndView.addObject("vacancies", vacancyService.findByRecruiter(user));
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

        return modelAndView;
    }

    @PreAuthorize("hasAnyAuthority('ROLE_HR')")
    @PostMapping("/vacancies/addVacancy")
    public String addVacancy(Model model,
                                   @Validated @ModelAttribute("vacancyForm") VacancyDTO vacancyDTO,
                                   BindingResult bindingResult,
                                   Principal principal) {
         UserDTO userDTO = userService.findByUsername(principal.getName());

        vacancyDTO.setRecruiter(userDTO);
        vacancyDTO.setCreateDate(LocalDate.now());

        vacancyService.save(vacancyDTO);

        return redirectTo("vacancies/myVacancies");
    }



}
