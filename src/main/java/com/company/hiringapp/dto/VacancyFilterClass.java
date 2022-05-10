package com.company.hiringapp.dto;

import com.company.hiringapp.entity.VacancyStatus;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class VacancyFilterClass extends AbstractDTO {
    private String position;
    private int fromSalary;
    private int toSalary;
    private CurrencyDTO currency;
    private int reqExperience;
    private CityDTO city;
    private CompanyDTO company;
    private JobTypeDTO jobType;
    private List<SkillDTO> skills;
    private VacancyStatus status;
}
