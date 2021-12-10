package com.company.hiringapp.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class RecruiterDTO extends AbstractDTO{
    private UserDTO user;
    private CompanyDTO companyDTO;
}
