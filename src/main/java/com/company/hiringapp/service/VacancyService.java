package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;

public interface VacancyService {
    VacancyDTO save(VacancyDTO dto);

    List<VacancyDTO> findByRecruiter(UserDTO recruiterDto);

    List<VacancyDTO> findByCity(CityDTO cityDto);

    List<VacancyDTO> findByJobType(JobTypeDTO jobTypeDto);

    void update(VacancyDTO vacancyDTO);
}
