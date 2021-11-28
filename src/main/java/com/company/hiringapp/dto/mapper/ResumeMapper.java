package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.entity.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class ResumeMapper extends AbstractMapper<Resume, ResumeDTO>{
    @Autowired
    public ResumeMapper(){super(Resume.class,ResumeDTO.class);}
}
