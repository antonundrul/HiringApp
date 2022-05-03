package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.LevelDTO;
import com.company.hiringapp.entity.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper extends AbstractMapper<Level, LevelDTO> {
    @Autowired
    public LevelMapper(){super(Level.class,LevelDTO.class);}
}
