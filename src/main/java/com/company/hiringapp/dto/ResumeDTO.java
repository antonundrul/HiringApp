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
public class ResumeDTO extends AbstractDTO{
    private UserDTO user;
    private LocalDate createDate;
    private CityDTO city;
    private String position;
}
