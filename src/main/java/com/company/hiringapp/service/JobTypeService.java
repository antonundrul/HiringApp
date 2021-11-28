package com.company.hiringapp.service;

import com.company.hiringapp.dto.CurrencyDTO;
import com.company.hiringapp.dto.JobTypeDTO;

import java.util.List;

public interface JobTypeService {
    List<JobTypeDTO> findAll();

    JobTypeDTO findById(Long id);

    JobTypeDTO findByName(String name);
}
