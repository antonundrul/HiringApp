package com.company.hiringapp.service;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.UserDTO;

import java.util.List;

public interface ResumeService {

    ResumeDTO save(ResumeDTO dto);

    List<ResumeDTO> findByUser(UserDTO userDTO);

    List<ResumeDTO> findByCity(CityDTO cityDTO);

    void update(ResumeDTO resumeDTO);
}
