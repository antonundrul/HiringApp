package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.VacancySkillSetDTO;
import com.company.hiringapp.entity.VacancySkillSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VacancySkillSetMapper extends AbstractMapper<VacancySkillSet, VacancySkillSetDTO> {
    @Autowired
    public VacancySkillSetMapper(){super(VacancySkillSet.class,VacancySkillSetDTO.class);}
}
