package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.SkillDTO;
import com.company.hiringapp.entity.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SkillMapper extends AbstractMapper<Skill, SkillDTO>{
    @Autowired
    public SkillMapper(){super(Skill.class,SkillDTO.class);}
}
