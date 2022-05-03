package com.company.hiringapp.service;

import com.company.hiringapp.dto.LevelDTO;

import java.util.List;

public interface LevelService {
    List<LevelDTO> findAll();

    LevelDTO findById(Long id);

    LevelDTO findByName(String name);
}
