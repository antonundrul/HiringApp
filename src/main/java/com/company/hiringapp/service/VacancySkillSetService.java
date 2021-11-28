package com.company.hiringapp.service;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeSkillSetDTO;
import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillSetDTO;

import java.util.List;

public interface VacancySkillSetService {
    VacancySkillSetDTO save(VacancySkillSetDTO dto);
    List<VacancySkillSetDTO> findByResume(VacancyDTO vacancyDTO);
    void delete(Long id);
}
