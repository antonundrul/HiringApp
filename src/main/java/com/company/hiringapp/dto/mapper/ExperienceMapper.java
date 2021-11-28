package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ExperienceDTO;
import com.company.hiringapp.entity.Experience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExperienceMapper extends AbstractMapper<Experience, ExperienceDTO> {
    @Autowired
    public ExperienceMapper(){super(Experience.class, ExperienceDTO.class);}

}
