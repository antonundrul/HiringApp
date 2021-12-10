package com.company.hiringapp.service;

import com.company.hiringapp.dto.CompanyDTO;

import java.util.List;

public interface CompanyService {
    List<CompanyDTO> findAll();

    CompanyDTO findById(Long id);

    CompanyDTO findByName(String name);

    CompanyDTO save(CompanyDTO dto);
}
