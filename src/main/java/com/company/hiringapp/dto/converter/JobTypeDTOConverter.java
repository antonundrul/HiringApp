package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.JobTypeDTO;
import com.company.hiringapp.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class JobTypeDTOConverter implements Converter<String, JobTypeDTO> {

    @Autowired
    private JobTypeService service;

    @Override
    public JobTypeDTO convert(String id) {
        return service.findById(Long.parseLong(id));
    }
}
