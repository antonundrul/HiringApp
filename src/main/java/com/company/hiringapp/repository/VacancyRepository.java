package com.company.hiringapp.repository;

import com.company.hiringapp.dto.RecruiterDTO;
import com.company.hiringapp.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VacancyRepository extends JpaRepository<Vacancy,Long> {
    @Override
    Optional<Vacancy> findById(Long id);

    List<Vacancy> findByCity(City city);
    List<Vacancy> findByRecruiter(Recruiter recruiter);
    List<Vacancy> findByJobType(JobType jobType);
}
