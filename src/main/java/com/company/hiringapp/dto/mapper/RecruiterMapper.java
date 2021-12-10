package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.entity.Recruiter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RecruiterMapper extends AbstractMapper<Recruiter, RecruiterDTO> {
    @Autowired
    public RecruiterMapper() {
        super(Recruiter.class, RecruiterDTO.class);
    }
}
