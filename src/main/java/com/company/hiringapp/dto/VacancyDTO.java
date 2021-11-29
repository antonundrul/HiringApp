package com.company.hiringapp.dto;

import com.company.hiringapp.entity.User;
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
public class VacancyDTO extends AbstractDTO{
    private String position;
    private String description;
    private int salary;
    private CurrencyDTO currency;
    private String companyName;
    private int reqExperience;
    private CityDTO city;
    private UserDTO recruiter;
    private JobTypeDTO jobType;
    private LocalDate createDate;
    private List<User> responses;
}
