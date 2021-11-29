package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;
import java.util.Map;

public interface VacancySkillSetService {
    VacancySkillSetDTO save(VacancySkillSetDTO dto);
    List<VacancySkillSetDTO> findByResume(VacancyDTO vacancyDTO);
    List<VacancySkillSetDTO> findAll();

//    Map<VacancyDTO,List<SkillDTO>>
    void delete(Long id);

    Map<VacancyDTO,List<VacancySkillSetDTO>> groupByVacancies(List<VacancyDTO> vacancies);

}
