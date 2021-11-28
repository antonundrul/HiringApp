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
public class ExperienceDTO extends AbstractDTO {

    private UserDTO user;
    private boolean isCurrentJob;
    private LocalDate startDate;
    private LocalDate endDate;
    private String companyName;
    private String description;
    private CityDTO city;
}
