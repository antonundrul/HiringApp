package com.company.hiringapp.repository;

import com.company.hiringapp.entity.VacancySkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacancySkillRepository extends JpaRepository<VacancySkill, Long> {
    @Override
    Optional<VacancySkill> findById(Long id);

}
