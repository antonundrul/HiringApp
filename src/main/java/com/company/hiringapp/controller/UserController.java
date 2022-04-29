package com.company.hiringapp.controller;


import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.dto.RoleDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.service.CompanyService;
import com.company.hiringapp.service.RecruiterService;
import com.company.hiringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Objects;
import java.util.Set;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class UserController {

    private final UserService userService;
    private final CompanyService companyService;
    private final RecruiterService recruiterService;


    @Autowired
    public UserController(UserService userService, CompanyService companyService, RecruiterService recruiterService) {
        this.userService = userService;
        this.companyService = companyService;
        this.recruiterService = recruiterService;
    }


    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/personal-cabinet")
    public String getPersonalCabinet(Model model,
                                     Principal principal) {

        UserDTO userDto = userService.findByUsername(principal.getName());

        model.addAttribute("user", userDto);
        return "/user/userPersonalCabinet";
//        return "/user/profile";
    }

    @PreAuthorize("hasAnyAuthority('ROLE_USER')")
    @GetMapping("/profile/{id}")
    public String getPersonalCabinet(Model model,
                                     @PathVariable(name = "id") Long id) {

        UserDTO userDto = userService.findById(id);

        model.addAttribute("user", userDto);
        return "/user/profile";
//        return "/user/profile";
    }

    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping("/update-user")
    public String updateUser(@Validated @ModelAttribute("user") UserDTO userDTO,
                             Principal principal,
                             BindingResult bindingResult,
                             Model model) {

        if (checkBindingResult(bindingResult)) {
            return goBackTo("user/userPersonalCabinet");
        }
        try {
            userDTO.setUsername(principal.getName());


            userService.update(userDTO);
        } catch (ServiceException ex) {
            model.addAttribute("error", ex.getMessage());
            return goBackTo("user/userPersonalCabinet");
        }
        return redirectTo("personal-cabinet");
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/users")
    public ModelAndView findAllUsers() {
        ModelAndView modelAndView = new ModelAndView();

        modelAndView.setViewName("admin/user/users");
        modelAndView.addObject("users", userService.findAll());

        return modelAndView;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/users/{id}")
    public String blockUser(@PathVariable(name = "id") Long id,
                            @RequestParam(required = false) String block,
                            @RequestParam(required = false) String hr,
                            @RequestParam(required = false) String admin) {

        UserDTO userDTO = userService.findById(id);
        if (Objects.nonNull(block)) {
            if (userDTO.getBlocked() == 0) {
                userDTO.setBlocked(1);
            } else userDTO.setBlocked(0);
        }
        if (Objects.nonNull(hr)) {
            RoleDTO roleDto = new RoleDTO();
            roleDto.setName("ROLE_HR");
            roleDto.setId(3L);
            if (userDTO.getRoles().contains(roleDto)) {
                userDTO.getRoles().remove(roleDto);
            } else userDTO.getRoles().add(roleDto);
        }
        if (Objects.nonNull(admin)) {
            RoleDTO roleDto = new RoleDTO();
            roleDto.setName("ROLE_ADMIN");
            roleDto.setId(2L);
            if (userDTO.getRoles().contains(roleDto)) {
                userDTO.getRoles().remove(roleDto);
            } else userDTO.getRoles().add(roleDto);
        }
        userService.update(userDTO);
        return redirectTo("users");
    }


    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @GetMapping("/recruiters/add")
    public ModelAndView addHR() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("recruiterForm", new RecruiterDTO());
        modelAndView.addObject("users", userService.findAll());
        modelAndView.addObject("companies", companyService.findAll());
        modelAndView.setViewName("admin/user/addHR");

        return modelAndView;
    }

    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    @PostMapping("/recruiters/add")
    public String addHR(Model model,
                        @Validated @ModelAttribute("recruiterForm") RecruiterDTO dto,
                        BindingResult result,
                        Principal principal) {
        if (checkBindingResult(result)) {
            model.addAttribute("recruiterForm", dto);
            return "admin/user/addHR";
        }

        try {
            Set<RoleDTO> roles = dto.getUser().getRoles();
            RoleDTO roleDto = new RoleDTO();
            roleDto.setName("ROLE_HR");
            roleDto.setId(3L);
            roles.add(roleDto);
            dto.getUser().setRoles(roles);
            userService.update(dto.getUser());
            recruiterService.save(dto);
        } catch (ServiceException e) {
            model.addAttribute("message", e.getMessage());
            return goBackTo("admin/user/addHR");
        }

        return redirectTo("");
    }


}
