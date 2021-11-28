package com.company.hiringapp.service;

import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.ResumeSkillSetDTO;

import java.util.List;

public interface ResumeSkillSetService {
    ResumeSkillSetDTO save(ResumeSkillSetDTO dto);
    List<ResumeSkillSetDTO> findByResume(ResumeDTO resumeDTO);
    void delete(Long id);
}
