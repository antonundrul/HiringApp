package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.CompanyDTO;
import com.company.hiringapp.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CompanyDTOConverter implements Converter<String, CompanyDTO> {
    @Autowired
    private CompanyService companyService;

    @Override
    public CompanyDTO convert(String id) {
        return companyService.findById(Long.parseLong(id));
    }
}
