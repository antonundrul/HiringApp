package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.JobTypeDTO;
import com.company.hiringapp.dto.mapper.JobTypeMapper;
import com.company.hiringapp.entity.JobType;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.JobTypeRepository;
import com.company.hiringapp.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeServiceImpl implements JobTypeService {
    @Autowired
    private JobTypeMapper jobTypeMapper;
    @Autowired
    private JobTypeRepository jobTypeRepository;

    @Override
    public List<JobTypeDTO> findAll() {
        return jobTypeMapper.toDtoList(jobTypeRepository.findAll());
    }

    @Override
    public JobTypeDTO findById(Long id) {
        JobType type = jobTypeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return jobTypeMapper.toDto(type);
    }

    @Override
    public JobTypeDTO findByName(String name) {
        return jobTypeMapper.toDto(jobTypeRepository.findByName(name));
    }
}
