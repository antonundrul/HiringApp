package com.company.hiringapp.service;

import com.company.hiringapp.dto.*;

import java.util.List;

public interface ExperienceService {
    ExperienceDTO save(ExperienceDTO dto);

    List<ExperienceDTO> findByUser(UserDTO userDTO);

    void update(ExperienceDTO experienceDTO);

}
