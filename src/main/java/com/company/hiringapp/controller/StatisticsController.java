package com.company.hiringapp.controller;

import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.dto.JobTypeDTO;
import com.company.hiringapp.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@Controller
public class StatisticsController {

    @Autowired
    private VacancyService vacancyService;


    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/statistics")
    public ModelAndView showStatistics() {
        ModelAndView modelAndView = new ModelAndView();

        Map<JobTypeDTO, Integer> jobTypesMap = getJobTypesMap();
        modelAndView.addObject("jobTypesMap", jobTypesMap);

        Map<CompanyDTO, Integer> companiesMap = getCompaniesMap();
        modelAndView.addObject("companiesMap", companiesMap);

        modelAndView.addObject("vacancies", vacancyService.findAll());


        modelAndView.setViewName("common/statistics");

        return modelAndView;
    }


    private Map<JobTypeDTO, Integer> getJobTypesMap() {
        Map<JobTypeDTO, Integer> jobTypesMap = new HashMap<>();
        for (int i = 0; i < vacancyService.findAll().size(); i++) {
            jobTypesMap.put(vacancyService.findAll().get(i).getJobType(), 0);
        }
        for (int i = 0; i < vacancyService.findAll().size(); i++) {
            for (Map.Entry<JobTypeDTO, Integer> entry : jobTypesMap.entrySet()) {
                if (entry.getKey().equals(vacancyService.findAll().get(i).getJobType())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }

        }
        return jobTypesMap;
    }

    private Map<CompanyDTO, Integer> getCompaniesMap() {
        Map<CompanyDTO, Integer> companyMap = new HashMap<>();
        for (int i = 0; i < vacancyService.findAll().size(); i++) {
            companyMap.put(vacancyService.findAll().get(i).getRecruiter().getCompany(), 0);
        }
        for (int i = 0; i < vacancyService.findAll().size(); i++) {
            for (Map.Entry<CompanyDTO, Integer> entry : companyMap.entrySet()) {
                if (entry.getKey().equals(vacancyService.findAll().get(i).getRecruiter().getCompany())) {
                    entry.setValue(entry.getValue() + 1);
                }
            }

        }
        return companyMap;
    }
}
