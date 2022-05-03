package com.company.hiringapp.service;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.UserDTO;

import java.util.List;

public interface ResumeService {

    ResumeDTO save(ResumeDTO dto);

    ResumeDTO findByUser(UserDTO userDTO);
    ResumeDTO findById(Long id);

    List<ResumeDTO> findByCity(CityDTO cityDTO);
    List<ResumeDTO> findAll();

    void update(ResumeDTO resumeDTO);
}
