package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkillRepository extends JpaRepository<Skill,Long> {
    @Override
    Optional<Skill> findById(Long id);

    Optional<Skill> findByName(String name);
}
