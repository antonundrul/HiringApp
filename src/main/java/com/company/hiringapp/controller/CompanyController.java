package com.company.hiringapp.controller;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.dto.mapper.CompanyMapper;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class CompanyController {
    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyService companyService;


    @GetMapping("/companies")
    public ModelAndView сompanies() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("companies", companyService.findAll());
        modelAndView.setViewName("company/companies");

        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/companies/add")
    public ModelAndView addCompany() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("companyForm", new CompanyDTO());
        modelAndView.setViewName("company/addCompany");

        return modelAndView;
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping("/companies/add")
    public String addCity(Model model,
                          @Validated @ModelAttribute("companyForm") CompanyDTO dto,
                          BindingResult result,
                          Principal principal) {
        if (checkBindingResult(result)) {
            model.addAttribute("companyForm", dto);
            return "company/addCompany";
        }

        try {
            companyService.save(dto);
        } catch (ServiceException e) {
            model.addAttribute("message", e.getMessage());
            return goBackTo("company/addCompany");
        }

        return redirectTo("");
    }

}
