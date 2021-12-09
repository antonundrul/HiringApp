package com.company.hiringapp.service;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.JobTypeDTO;

import java.util.List;

public interface CityService {
    List<CityDTO> findAll();

    CityDTO findById(Long id);

    CityDTO findByName(String name);

    CityDTO save(CityDTO dto);
}
