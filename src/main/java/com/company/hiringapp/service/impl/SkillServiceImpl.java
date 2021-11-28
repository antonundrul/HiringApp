package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.SkillDTO;
import com.company.hiringapp.dto.mapper.SkillMapper;
import com.company.hiringapp.entity.Skill;
import com.company.hiringapp.entity.User;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.exception.ServiceException;
import com.company.hiringapp.repository.SkillRepository;
import com.company.hiringapp.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class SkillServiceImpl implements SkillService {
    @Autowired
    private SkillRepository repository;
    @Autowired
    private SkillMapper mapper;

    @Override
    @Transactional
    public SkillDTO save(SkillDTO dto) {
        repository.findByName(dto.getName())
                .ifPresent(value -> {
                    throw new ServiceException("Такой навык уже существует!");
                });

        Skill skill = mapper.toEntity(dto);

        repository.save(skill);
        return dto;
    }

    @Override
    public SkillDTO findByName(String name) {
        Skill skill = repository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException(name));

        return mapper.toDto(skill);
    }

    @Override
    public List<SkillDTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public SkillDTO findById(Long id) {
        Skill skill = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.toDto(skill);
    }
}
