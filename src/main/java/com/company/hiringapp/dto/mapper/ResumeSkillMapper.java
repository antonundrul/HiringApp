package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.ResumeSkillDTO;
import com.company.hiringapp.entity.ResumeSkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResumeSkillMapper extends AbstractMapper<ResumeSkill, ResumeSkillDTO> {
    @Autowired
    public ResumeSkillMapper(){super(ResumeSkill.class,ResumeSkillDTO.class);}
}
