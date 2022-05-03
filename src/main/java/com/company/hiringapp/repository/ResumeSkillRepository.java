package com.company.hiringapp.repository;

import com.company.hiringapp.entity.ResumeSkill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResumeSkillRepository extends JpaRepository<ResumeSkill, Long> {
    @Override
    Optional<ResumeSkill> findById(Long id);
}
