package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ResumeSkillSetDTO;
import com.company.hiringapp.entity.ResumeSkillSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.Column;

@Component
public class ResumeSkillSetMapper extends AbstractMapper<ResumeSkillSet, ResumeSkillSetDTO> {
    @Autowired
    public ResumeSkillSetMapper(){super(ResumeSkillSet.class,ResumeSkillSetDTO.class);}
}
