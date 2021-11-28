package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.ExperienceDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.ExperienceMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.entity.Experience;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ExperienceRepository;
import com.company.hiringapp.service.ExperienceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienceServiceImpl implements ExperienceService {
    @Autowired
    private ExperienceRepository repository;
    @Autowired
    private ExperienceMapper experienceMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ExperienceDTO save(ExperienceDTO dto) {
        repository.save(experienceMapper.toEntity(dto));
        return dto;
    }

    @Override
    public List<ExperienceDTO> findByUser(UserDTO userDTO) {
        return experienceMapper.toDtoList(repository.findByUser(userMapper.toEntity(userDTO)));
    }

    @Override
    public void update(ExperienceDTO experienceDTO) {
        Experience experience = repository.findById(experienceDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(experienceDTO.getId()));

        repository.save(experienceMapper.toEntity(experienceDTO));
    }
}
