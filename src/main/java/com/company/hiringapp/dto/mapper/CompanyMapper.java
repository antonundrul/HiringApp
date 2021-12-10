package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.entity.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyMapper extends AbstractMapper<Company, CompanyDTO> {
    @Autowired
    public CompanyMapper(){super(Company.class,CompanyDTO.class);}
}
