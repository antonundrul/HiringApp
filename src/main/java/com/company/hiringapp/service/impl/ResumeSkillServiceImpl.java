package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeSkillDTO;
import com.company.hiringapp.dto.VacancySkillDTO;
import com.company.hiringapp.dto.mapper.ResumeMapper;
import com.company.hiringapp.dto.mapper.ResumeSkillMapper;
import com.company.hiringapp.entity.ResumeSkill;
import com.company.hiringapp.entity.VacancySkill;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ResumeSkillRepository;
import com.company.hiringapp.service.ResumeSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ResumeSkillServiceImpl implements ResumeSkillService {

    @Autowired private ResumeSkillRepository resumeSkillRepository;
    @Autowired private ResumeSkillMapper resumeSkillMapper;
    @Autowired private ResumeMapper resumeMapper;


    @Override
    public List<ResumeSkillDTO> findAll() {
        return resumeSkillMapper.toDtoList(resumeSkillRepository.findAll());
    }

    @Override
    public ResumeSkillDTO findById(Long id) {
        ResumeSkill resumeSkill = resumeSkillRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return resumeSkillMapper.toDto(resumeSkill);
    }

    @Override
    public List<ResumeSkillDTO> findByResume(ResumeDTO resumeDTO) {
        List<ResumeSkillDTO> result = new ArrayList<>();
        List<ResumeSkillDTO> resumeSkillList = resumeSkillMapper.toDtoList(resumeSkillRepository.findAll());

        for (ResumeSkillDTO resumeSkill : resumeSkillList) {
            if (resumeDTO.equals(resumeSkill.getResume())) {
                result.add(resumeSkill);
            }
        }

        return result;
    }

    @Override
    public ResumeSkillDTO save(ResumeSkillDTO dto) {
        resumeSkillRepository.save(resumeSkillMapper.toEntity(dto));
        return dto;
    }

    @Override
    public void delete(ResumeSkillDTO dto) {
        resumeSkillRepository.delete(resumeSkillMapper.toEntity(dto));
    }
}
