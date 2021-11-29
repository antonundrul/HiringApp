package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.dto.JobTypeDTO;
import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.dto.mapper.CityMapper;
import com.company.hiringapp.dto.mapper.JobTypeMapper;
import com.company.hiringapp.dto.mapper.UserMapper;
import com.company.hiringapp.dto.mapper.VacancyMapper;
import com.company.hiringapp.entity.Resume;
import com.company.hiringapp.entity.User;
import com.company.hiringapp.entity.Vacancy;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.VacancyRepository;
import com.company.hiringapp.service.VacancyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VacancyServiceImpl implements VacancyService {
    @Autowired
    private VacancyRepository vacancyRepository;
    @Autowired
    private VacancyMapper vacancyMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private JobTypeMapper jobTypeMapper;

    @Override
    public VacancyDTO save(VacancyDTO dto) {
        vacancyRepository.save(vacancyMapper.toEntity(dto));
        return null;
    }

    @Override
    public VacancyDTO findById(Long id) {
        Vacancy vacancy = vacancyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));

        return vacancyMapper.toDto(vacancy);
    }

    @Override
    public List<VacancyDTO> findAll() {
        return vacancyMapper.toDtoList(vacancyRepository.findAll());
    }

    @Override
    public List<VacancyDTO> findByRecruiter(UserDTO recruiterDto) {
        return vacancyMapper.toDtoList(vacancyRepository.findByRecruiter(userMapper.toEntity(recruiterDto)));
    }

    @Override
    public List<VacancyDTO> findByCity(CityDTO cityDto) {
        return vacancyMapper.toDtoList(vacancyRepository.findByCity(cityMapper.toEntity(cityDto)));
    }

    @Override
    public List<VacancyDTO> findByJobType(JobTypeDTO jobTypeDto) {
        return vacancyMapper.toDtoList(vacancyRepository.findByJobType(jobTypeMapper.toEntity(jobTypeDto)));
    }

    @Override
    public void update(VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyRepository.findById(vacancyDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(vacancyDTO.getId()));

        vacancyRepository.save(vacancyMapper.toEntity(vacancyDTO));

    }

    @Override
    public void addResponse(Long id, UserDTO dto) {
        VacancyDTO vacancy = this.findById(id);
        List<User> list = vacancy.getResponses();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(userMapper.toEntity(dto));
        vacancy.setResponses(list);
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }

    @Override
    public void removeResponse(Long id, UserDTO dto) {
        VacancyDTO vacancy=  this.findById(id);
        List<User> list = vacancy.getResponses();
        if (list != null) {
            list.remove(userMapper.toEntity(dto));
        }
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }
}
