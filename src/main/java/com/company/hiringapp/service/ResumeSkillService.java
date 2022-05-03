package com.company.hiringapp.service;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeSkillDTO;

import java.util.List;

public interface ResumeSkillService {
    List<ResumeSkillDTO> findAll();

    ResumeSkillDTO findById(Long id);

    List<ResumeSkillDTO> findByResume(ResumeDTO resumeDTO);

    ResumeSkillDTO save(ResumeSkillDTO dto);

    void delete(ResumeSkillDTO dto);
}
