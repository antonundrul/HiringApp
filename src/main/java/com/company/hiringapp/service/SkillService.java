package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;

public interface SkillService {
    SkillDTO save(SkillDTO dto);

    SkillDTO findByName(String name);

    List<SkillDTO> findAll();

    SkillDTO findById(Long id);

}
