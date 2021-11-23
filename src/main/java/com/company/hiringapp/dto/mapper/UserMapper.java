package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<User, UserDTO> {

    @Autowired
    public UserMapper() {
        super(User.class, UserDTO.class);
    }
}
