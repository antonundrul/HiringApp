package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ResumeDTO extends AbstractDTO{
    private UserDTO user;
    private LocalDate createDate;
    private CityDTO city;
    private String position;
    private List<SkillDTO> skills;
    private List<ExperienceDTO> experiences;
}
