package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillSetDTO;
import com.company.hiringapp.dto.mapper.VacancyMapper;
import com.company.hiringapp.dto.mapper.VacancySkillSetMapper;
import com.company.hiringapp.entity.ResumeSkillSet;
import com.company.hiringapp.entity.VacancySkillSet;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.VacancySkillSetRepository;
import com.company.hiringapp.service.VacancySkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VacancySkillSetServiceImpl implements VacancySkillSetService {
    @Autowired
    private VacancySkillSetMapper vacancySkillSetMapper;
    @Autowired
    private VacancySkillSetRepository vacancySkillSetRepository;
    @Autowired
    private VacancyMapper vacancyMapper;

    @Override
    public VacancySkillSetDTO save(VacancySkillSetDTO dto) {
        vacancySkillSetRepository.save(vacancySkillSetMapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<VacancySkillSetDTO> findByResume(VacancyDTO vacancyDTO) {
        return vacancySkillSetMapper.toDtoList(vacancySkillSetRepository.findByVacancy(vacancyMapper.toEntity(vacancyDTO)));
    }

    @Override
    public void delete(Long id) {
        VacancySkillSet vacancySkillSet = vacancySkillSetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        vacancySkillSetRepository.delete(vacancySkillSet);
    }
}
