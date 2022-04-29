package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.*;
import com.company.hiringapp.dto.mapper.*;
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
    @Autowired
    private RecruiterMapper recruiterMapper;

    @Override
    public VacancyDTO save(VacancyDTO dto) {
        vacancyRepository.save(vacancyMapper.toEntity(dto));
        return null;
    }

    @Override
    public void delete(VacancyDTO dto) {
        vacancyRepository.delete(vacancyMapper.toEntity(dto));
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
    public List<VacancyDTO> findByRecruiter(RecruiterDTO recruiterDto) {
        return vacancyMapper.toDtoList(vacancyRepository.findByRecruiter(recruiterMapper.toEntity(recruiterDto)));
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
    public List<VacancyDTO> myResponses(UserDTO userDTO) {
        List<VacancyDTO> vacancies = this.findAll();
        List<VacancyDTO> responses = new ArrayList<>();
        for(VacancyDTO vacancy:vacancies){
            if(vacancy.getResponses().contains(userDTO)){
                responses.add(vacancy);
            }
        }
        return responses;
    }

    @Override
    public void update(VacancyDTO vacancyDTO) {
        Vacancy vacancy = vacancyRepository.findById(vacancyDTO.getId())
                .orElseThrow(() -> new ResourceNotFoundException(vacancyDTO.getId()));

        vacancyRepository.save(vacancyMapper.toEntity(vacancyDTO));

    }

    @Override
    public void addSkill(Long id, SkillDTO skill) {
        VacancyDTO vacancy = this.findById(id);
        List<SkillDTO> skills = vacancy.getSkills();
        if (skills == null) {
            skills = new ArrayList<>();
        }
        skills.add(skill);
        vacancy.setSkills(skills);
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }

    @Override
    public void removeSkill(Long id, SkillDTO skill) {
        VacancyDTO vacancy = this.findById(id);
        List<SkillDTO> skills = vacancy.getSkills();
        if (skills != null) {
            skills.remove(skill);
        }
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }

    @Override
    public void addResponse(Long id, UserDTO dto) {
        VacancyDTO vacancy = this.findById(id);
        List<UserDTO> list = vacancy.getResponses();
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(dto);
        vacancy.setResponses(list);
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }

    @Override
    public void removeResponse(Long id, UserDTO dto) {
        VacancyDTO vacancy = this.findById(id);
        List<UserDTO> list = vacancy.getResponses();
        if (list != null) {
            vacancy.getResponses().remove(dto);
        }
        vacancyRepository.save(vacancyMapper.toEntity(vacancy));
    }
}
