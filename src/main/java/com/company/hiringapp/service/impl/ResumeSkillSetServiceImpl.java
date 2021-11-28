package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeSkillSetDTO;
import com.company.hiringapp.dto.mapper.ResumeMapper;
import com.company.hiringapp.dto.mapper.ResumeSkillSetMapper;
import com.company.hiringapp.dto.mapper.SkillMapper;
import com.company.hiringapp.entity.ResumeSkillSet;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ResumeSkillSetRepository;
import com.company.hiringapp.service.ResumeSkillSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeSkillSetServiceImpl implements ResumeSkillSetService {
    @Autowired
    private ResumeSkillSetMapper resumeSkillSetMapper;
    @Autowired
    private ResumeSkillSetRepository resumeSkillSetRepository;
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private SkillMapper skillMapper;

    @Override
    public ResumeSkillSetDTO save(ResumeSkillSetDTO dto) {
        resumeSkillSetRepository.save(resumeSkillSetMapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<ResumeSkillSetDTO> findByResume(ResumeDTO resumeDTO) {
        return resumeSkillSetMapper.toDtoList(resumeSkillSetRepository.findByResume(resumeMapper.toEntity(resumeDTO)));
    }

    @Override
    public void delete(Long id) {
        ResumeSkillSet resumeSkillSet = resumeSkillSetRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        resumeSkillSetRepository.delete(resumeSkillSet);
    }
}
