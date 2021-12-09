package com.company.hiringapp.controller;


import com.company.hiringapp.dto.RoleDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.UserDTOwithPhoto;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Objects;

import static com.company.hiringapp.controller.ControllerHelper.*;

@Controller
public class UserController {

    private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
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
        return "/user/userPersonalCabinet";
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
//            UserDTO userDto = userService.convertUserDTOwithPhoto(userDTOwithPhoto);
            userDTO.setUsername(principal.getName());
            /*String filename = userDTOwithPhoto.getAvatar().getOriginalFilename();
            File dir = new File("C://Bsuir/7sem/coursework/HiringApp/src/main/webapp/resources/images");
            if (filename != null) {
                File avatar = (File) userDTOwithPhoto.getAvatar();
                avatar.createNewFile();
            }
*/

            userService.update(userDTO);
        } catch (ServiceException ex) {
            model.addAttribute("error", ex.getMessage());
            return goBackTo("user/userPersonalCabinet");
        }
        return redirectTo("personal-cabinet");
    }


    //    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
                            @RequestParam(required = false) String seller,
                            @RequestParam(required = false) String admin) {

        UserDTO userDTO = userService.findById(id);
        if (Objects.nonNull(block)) {
            if (userDTO.getBlocked() == 0) {
                userDTO.setBlocked(1);
            } else userDTO.setBlocked(0);
        }
        if (Objects.nonNull(seller)) {
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


}
