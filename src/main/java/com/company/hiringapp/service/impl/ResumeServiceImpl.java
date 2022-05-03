package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.ResumeDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.mapper.CityMapper;
import com.company.hiringapp.dto.mapper.ResumeMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.entity.Resume;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.ResumeRepository;
import com.company.hiringapp.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeServiceImpl implements ResumeService {
    @Autowired
    private ResumeRepository resumeRepository;
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResumeDTO save(ResumeDTO dto) {
        resumeRepository.save(resumeMapper.toEntity(dto));
        return dto;
    }

    @Override
    public ResumeDTO findByUser(UserDTO userDTO) {

        return resumeMapper.toDto(resumeRepository.findByUser(userMapper.toEntity(userDTO)));
    }

    @Override
    public List<ResumeDTO> findByCity(CityDTO cityDTO) {
        return resumeMapper.toDtoList(resumeRepository.findByCity(cityMapper.toEntity(cityDTO)));
    }

    @Override
    public List<ResumeDTO> findAll() {
        return resumeMapper.toDtoList(resumeRepository.findAll());
    }

    @Override
    public void update(ResumeDTO resumeDTO) {
        Resume resume = resumeRepository.findById(resumeDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(resumeDTO.getId()));

        resumeRepository.save(resumeMapper.toEntity(resumeDTO));

    }

    @Override
    public ResumeDTO findById(Long id) {
        Resume resume = resumeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return resumeMapper.toDto(resume);
    }
}
