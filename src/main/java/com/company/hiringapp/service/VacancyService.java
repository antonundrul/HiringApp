package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;

public interface VacancyService {
    VacancyDTO save(VacancyDTO dto);

    VacancyDTO findById(Long id);

    List<VacancyDTO> findAll();
    List<VacancyDTO> findByRecruiter(UserDTO recruiterDto);

    List<VacancyDTO> findByCity(CityDTO cityDto);

    List<VacancyDTO> findByJobType(JobTypeDTO jobTypeDto);

    void update(VacancyDTO vacancyDTO);

    void addResponse(Long id, UserDTO dto);

    void removeResponse(Long id, UserDTO dto);
}
