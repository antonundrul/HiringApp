package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.service.RecruiterService;
import com.company.hiringapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDTOConverter implements Converter<String, UserDTO>{
    @Autowired
    private UserService userService;

    @Override
    public UserDTO convert(String id) {
        return userService.findById(Long.parseLong(id));
    }
}
