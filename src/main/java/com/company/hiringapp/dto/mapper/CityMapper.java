package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.entity.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CityMapper extends AbstractMapper<City, CityDTO> {
    @Autowired
    public CityMapper(){super(City.class,CityDTO.class);}
}
