package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.RecruiterMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.entity.Recruiter;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.RecruiterRepository;
import com.company.hiringapp.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruiterServiceImpl implements RecruiterService {
    @Autowired
    private RecruiterMapper recruiterMapper;
    @Autowired
    private RecruiterRepository recruiterRepository;
    @Autowired
    private UserMapper userMapper;


    @Override
    public List<RecruiterDTO> findAll() {
        return recruiterMapper.toDtoList(recruiterRepository.findAll());
    }

    @Override
    public RecruiterDTO findById(Long id) {
        Recruiter recruiter = recruiterRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return recruiterMapper.toDto(recruiter);
    }

    @Override
    public RecruiterDTO findByUser(UserDTO userDTO) {
        return recruiterMapper.toDto(recruiterRepository.findByUser(userMapper.toEntity(userDTO)));
    }

    @Override
    public RecruiterDTO save(RecruiterDTO dto) {
        recruiterRepository.save(recruiterMapper.toEntity(dto));
        return dto;
    }
}
