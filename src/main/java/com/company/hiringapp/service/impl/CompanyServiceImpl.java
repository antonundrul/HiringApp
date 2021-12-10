package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.dto.mapper.CompanyMapper;
import com.company.hiringapp.entity.City;
import com.company.hiringapp.entity.Company;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.CompanyRepository;
import com.company.hiringapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CompanyMapper companyMapper;

    @Override
    public List<CompanyDTO> findAll() {
        return companyMapper.toDtoList(companyRepository.findAll());
    }

    @Override
    public CompanyDTO findById(Long id) {
        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return companyMapper.toDto(company);
    }

    @Override
    public CompanyDTO findByName(String name) {
        return companyMapper.toDto(companyRepository.findByName(name));
    }

    @Override
    public CompanyDTO save(CompanyDTO dto) {
         companyRepository.save(companyMapper.toEntity(dto));
    return dto;
    }
}

