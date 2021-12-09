package com.company.hiringapp.controller;

import com.company.hiringapp.dto.*;
import com.company.hiringapp.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class ResumeController {
    @Autowired
    private ResumeService resumeService;
    @Autowired
    private ResumeSkillSetService resumeSkillSetService;
    @Autowired
    private UserService userService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private CityService cityService;
    @Autowired
    private SkillService skillService;


    @GetMapping("/resumes")
    public ModelAndView findAllResumes(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("resume/resumes");
        modelAndView.addObject("resumes", resumeService.findAll());

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/resume/add")
    public ModelAndView addResume(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("resume/addResume");
        UserDTO user = userService.findByUsername(principal.getName());

        modelAndView.addObject("resumeForm", new ResumeDTO());
        modelAndView.addObject("cities", cityService.findAll());
        modelAndView.addObject("skills", skillService.findAll());

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/resume/add")
    public String addResume(Model model,
                             @Validated @ModelAttribute("resumeForm") ResumeDTO resumeDTO,
                             BindingResult bindingResult,
                             Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());

        resumeDTO.setUser(userDTO);
        resumeDTO.setCreateDate(LocalDate.now());

        resumeService.save(resumeDTO);

        return redirectTo("user/userPersonalCabinet");
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/resume/{id}")
    public ModelAndView resume(Principal principal,
                               @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("resume/resume");
        UserDTO user = userService.findById(id);
        UserDTO currentUser = userService.findByUsername(principal.getName());
        ResumeDTO resume = resumeService.findByUser(user);

        boolean isCurrentUser = false;
        if(user.getId()==currentUser.getId()){
            isCurrentUser=true;
        }


        modelAndView.addObject("isCurrentUser", isCurrentUser);
        modelAndView.addObject("user", user);
        modelAndView.addObject("resume", resume);

        return modelAndView;
    }


    /*@GetMapping("/vacancies/delete/{id}")
    public String delete(@PathVariable Long id, Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());
        VacancyDTO vacancyDTO = vacancyService.findById(id);

        vacancyService.delete(vacancyDTO);
        return redirectTo("vacancies");
    }*/

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/experiences/add/{id}")
    public ModelAndView addExperience(Principal principal,
                                      @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("resume/addExperience");
        UserDTO user = userService.findByUsername(principal.getName());

        modelAndView.addObject("experienceForm", new ExperienceDTO2());
        modelAndView.addObject("resume", resumeService.findByid(id));
        modelAndView.addObject("cities", cityService.findAll());

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/experiences/add/{id}")
    public String addExperience(Model model,
                            @Validated @ModelAttribute("experienceForm") ExperienceDTO2 experienceDTO2,
                            @PathVariable(name = "id") Long id,
                            BindingResult bindingResult,
                            Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName());

        ExperienceDTO experienceDTO = new ExperienceDTO();
        experienceDTO.setUser(userDTO);
        experienceDTO.setPosition(experienceDTO2.getPosition());
        experienceDTO.setCompanyName(experienceDTO2.getCompanyName());
        experienceDTO.setDescription(experienceDTO2.getDescription());
        experienceDTO.setCity(experienceDTO2.getCity());
        experienceDTO.setStartDate(LocalDate.parse(experienceDTO2.getStartDate()));
        if (experienceDTO2.getEndDate().equals(LocalDate.now())
                || experienceDTO2.getEndDate() == null){
            experienceDTO.setEndDate(null);
            experienceDTO.setCurrentJob(true);
        }
        else{
            experienceDTO.setEndDate(LocalDate.parse(experienceDTO2.getEndDate()));
            experienceDTO.setCurrentJob(false);
        }

        ResumeDTO resumeDTO = resumeService.findByid(id);
        List<ExperienceDTO> experienceList = resumeDTO.getExperiences();
        experienceList.add(experienceDTO);
        resumeDTO.setExperiences(experienceList);

        resumeService.save(resumeDTO);

        return redirectTo("resume/"+id);
    }

}
