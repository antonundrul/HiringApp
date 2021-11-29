package com.company.hiringapp.controller;

import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillSetDTO;
import com.company.hiringapp.service.UserService;
import com.company.hiringapp.service.VacancyService;
import com.company.hiringapp.service.VacancySkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

import static com.company.hiringapp.controller.ControllerHelper.redirectTo;


@Controller
@RequestMapping("/vacancies")
public class VacancyController {

    @Autowired
    private VacancyService vacancyService;
    @Autowired
    private VacancySkillSetService vacancySkillSetService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("vacancy/vacancies");
        modelAndView.addObject("vacancyMap", vacancySkillSetService.groupByVacancies(vacancyService.findAll()));

        return modelAndView;
    }


    @GetMapping("/vacancyDetail/{id}")
    public String vacancyDetail(Model model, @PathVariable(name = "id") Long id,Principal principal) {

        VacancyDTO vacancyDTO = vacancyService.findById(id);
        List<VacancySkillSetDTO> vacancySkillSetDTOList = vacancySkillSetService.findByResume(vacancyDTO);

        model.addAttribute("vacancy", vacancyDTO);
        model.addAttribute("skillList", vacancySkillSetDTOList);
        if (principal != null) {
            model.addAttribute("user", userService.findByUsername(principal.getName()));
            if(vacancyDTO.getResponses().size()!=0) {
                for (int i = 0; i < vacancyDTO.getResponses().size(); i++) {
                    System.out.println(vacancyDTO.getResponses().get(i).getUsername());
                }
            }
            else{
                System.out.println("Откликов нету");
            }
        }

        else model.addAttribute("user", new UserDTO());

        return "/vacancy/vacancyDetail";
    }

    @GetMapping("vacancyDetail/{id}/subscribe")
    public String subscribe(@PathVariable(name = "id") Long id,
                            Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.addResponse(id, userDTO);

        return redirectTo("vacancies/vacancyDetail/" + id);
    }

    @GetMapping("vacancyDetail/{id}/unsubscribe")
    public String unsubscribe(@PathVariable(name = "id") Long id,
                              Principal principal) {

        UserDTO userDTO = userService.findByUsername(principal.getName());
        vacancyService.removeResponse(id, userDTO);

        return redirectTo("vacancies/vacancyDetail/" + id);
    }
}