package com.company.hiringapp.dto;

import com.company.hiringapp.entity.VacancyStatus;
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
public class VacancyDTO extends AbstractDTO {
    private String position;
    private String description;
    private int salary;
    private CurrencyDTO currency;
    private int reqExperience;
    private CityDTO city;
    private RecruiterDTO recruiter;
    private JobTypeDTO jobType;
    private LocalDate createDate;
    private List<UserDTO> responses;
    private List<SkillDTO> skills;
    private VacancyStatus status;
}
