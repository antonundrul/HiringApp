package com.company.hiringapp.service;



import com.company.hiringapp.dto.PageWrapper;
import com.company.hiringapp.dto.SignUpRequest;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.UserDTOwithPhoto;

import java.util.List;

public interface UserService {

    void signUp(SignUpRequest signUpRequest);

    UserDTO save(UserDTO userDto);

    UserDTO findByUsername(String username);

    void update(UserDTO userDto);

    PageWrapper<UserDTO> findAll(int page, int size);

    List<UserDTO> findAll();

    UserDTO findById(Long id);

    UserDTO convertUserDTOwithPhoto(UserDTOwithPhoto withPhoto);
    UserDTOwithPhoto convertUserDTO(UserDTO dto);
}
