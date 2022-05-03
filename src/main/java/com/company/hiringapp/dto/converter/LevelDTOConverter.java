package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.LevelDTO;
import com.company.hiringapp.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class LevelDTOConverter implements Converter<String, LevelDTO> {

    @Autowired
    private LevelService service;

    @Override
    public LevelDTO convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
