package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CityDTOConverter implements Converter<String, CityDTO> {
    @Autowired
    private CityService service;

    @Override
    public CityDTO convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
