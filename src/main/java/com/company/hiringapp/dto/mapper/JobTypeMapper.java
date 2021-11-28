package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.JobTypeDTO;
import com.company.hiringapp.entity.JobType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JobTypeMapper extends AbstractMapper<JobType, JobTypeDTO> {
    @Autowired
    public JobTypeMapper() {
        super(JobType.class, JobTypeDTO.class);
    }
}
