package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.VacancyDTO;
import com.company.hiringapp.entity.Vacancy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VacancyMapper extends AbstractMapper<Vacancy, VacancyDTO> {
    @Autowired
    public VacancyMapper(){super(Vacancy.class,VacancyDTO.class);}
}
