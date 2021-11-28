package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.mapper.CityMapper;
import com.company.hiringapp.entity.City;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.CityRepository;
import com.company.hiringapp.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityRepository repository;
    @Autowired
    private CityMapper mapper;


    @Override
    public List<CityDTO> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    @Override
    public CityDTO findById(Long id) {
        City city = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return mapper.toDto(city);
    }

    @Override
    public CityDTO findByName(String name) {
        return mapper.toDto(repository.findByName(name));
    }
}
