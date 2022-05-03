package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.VacancySkillDTO;
import com.company.hiringapp.dto.mapper.VacancyMapper;
import com.company.hiringapp.dto.mapper.VacancySkillMapper;
import com.company.hiringapp.entity.VacancySkill;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.VacancySkillRepository;
import com.company.hiringapp.service.VacancySkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacancySkillServiceImpl implements VacancySkillService {

    @Autowired
    private VacancySkillRepository vacancySkillRepository;
    @Autowired
    private VacancySkillMapper vacancySkillMapper;
    @Autowired
    private VacancyMapper vacancyMapper;

    @Override
    public List<VacancySkillDTO> findAll() {
        return vacancySkillMapper.toDtoList(vacancySkillRepository.findAll());
    }

    @Override
    public VacancySkillDTO findById(Long id) {
        VacancySkill vacancySkill = vacancySkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return vacancySkillMapper.toDto(vacancySkill);
    }

    @Override
    public List<VacancySkillDTO> findByVacancy(VacancyDTO vacancyDTO) {
        List<VacancySkillDTO> result = new ArrayList<>();
        List<VacancySkillDTO> vacancySkillList = vacancySkillMapper.toDtoList(vacancySkillRepository.findAll());

        for (VacancySkillDTO vacancySkill : vacancySkillList) {
            if (vacancyDTO.equals(vacancySkill.getVacancy())) {
                result.add(vacancySkill);
            }
        }

        return result;
    }

    @Override
    public VacancySkillDTO save(VacancySkillDTO dto) {
        vacancySkillRepository.save(vacancySkillMapper.toEntity(dto));
        return dto;
    }
}
