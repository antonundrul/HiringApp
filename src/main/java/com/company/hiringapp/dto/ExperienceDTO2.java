package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class ExperienceDTO2 extends AbstractDTO {

    private UserDTO user;
    private boolean isCurrentJob;
    private  String startDate;
    private String endDate;
    private String companyName;
    private String position;
    private String description;
    private CityDTO city;
}
