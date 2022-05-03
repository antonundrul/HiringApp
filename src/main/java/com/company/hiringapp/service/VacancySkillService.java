package com.company.hiringapp.service;

import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillDTO;

import java.util.List;

public interface VacancySkillService {
    List<VacancySkillDTO> findAll();

    VacancySkillDTO findById(Long id);

    List<VacancySkillDTO> findByVacancy(VacancyDTO vacancyDTO);

    VacancySkillDTO save(VacancySkillDTO dto);
}
