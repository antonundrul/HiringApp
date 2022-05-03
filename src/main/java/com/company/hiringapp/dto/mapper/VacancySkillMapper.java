package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.VacancySkillDTO;
import com.company.hiringapp.entity.VacancySkill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VacancySkillMapper extends AbstractMapper<VacancySkill, VacancySkillDTO> {
    @Autowired
    public VacancySkillMapper(){super(VacancySkill.class,VacancySkillDTO.class);}
}
