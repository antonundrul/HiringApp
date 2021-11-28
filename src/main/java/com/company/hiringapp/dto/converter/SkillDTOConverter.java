package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.SkillDTO;
import com.company.hiringapp.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class SkillDTOConverter implements Converter<String, SkillDTO> {
    @Autowired
    private SkillService service;

    @Override
    public SkillDTO convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
