package com.company.hiringapp.repository;

import com.company.hiringapp.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JobTypeRepository extends JpaRepository<JobType,Long> {
    @Override
    Optional<JobType> findById(Long id);

    JobType findByName(String name);
}
