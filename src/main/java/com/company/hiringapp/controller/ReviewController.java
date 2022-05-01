package com.company.hiringapp.controller;

import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeReviewDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.ResumeReview;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.service.ResumeReviewService;
import com.company.hiringapp.service.ResumeService;
import com.company.hiringapp.service.UserService;
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
import java.util.List;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class ReviewController {

    @Autowired private ResumeService resumeService;
    @Autowired private UserService userService;
    @Autowired private ResumeReviewService reviewService;

    @PreAuthorize("isAuthenticated() && hasRole('ROLE_HR')")
    @GetMapping("/reviews/{id}")
    public ModelAndView review(Principal principal,
                               @PathVariable(name = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("review/reviews");
        UserDTO user = userService.findById(id);
        ResumeDTO resume = resumeService.findByUser(user);
        List<ResumeReviewDTO> reviews = reviewService.findByResume(resume);

        modelAndView.addObject("reviews", reviews);

        return modelAndView;
    }



}
