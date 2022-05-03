package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.LevelDTO;
import com.company.hiringapp.dto.mapper.LevelMapper;
import com.company.hiringapp.entity.Level;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.LevelRepository;
import com.company.hiringapp.service.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LevelServiceImpl implements LevelService {

    @Autowired
    private LevelMapper levelMapper;
    @Autowired
    private LevelRepository levelRepository;

    @Override
    public List<LevelDTO> findAll() {
        return levelMapper.toDtoList(levelRepository.findAll());
    }

    @Override
    public LevelDTO findById(Long id) {
        Level level = levelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return levelMapper.toDto(level);
    }

    @Override
    public LevelDTO findByName(String name) {
        return levelMapper.toDto(levelRepository.findByName(name));
    }
}
