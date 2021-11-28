package com.company.hiringapp.repository;

import com.company.hiringapp.entity.JobType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobTypeRepository extends JpaRepository<JobType,Long> {
    @Override
    Optional<JobType> findById(Long id);

    JobType findByName(String name);
}
