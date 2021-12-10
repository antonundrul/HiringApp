package com.company.hiringapp.service;

import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.dto.UserDTO;

import java.util.List;

public interface RecruiterService {
    List<RecruiterDTO> findAll();

    RecruiterDTO findById(Long id);

    RecruiterDTO findByUser(UserDTO userDTO);

    RecruiterDTO save(RecruiterDTO dto);
}
