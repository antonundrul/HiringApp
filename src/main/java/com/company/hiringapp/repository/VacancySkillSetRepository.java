package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Vacancy;
import com.company.hiringapp.entity.VacancySkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VacancySkillSetRepository extends JpaRepository<VacancySkillSet,Long> {
    List<VacancySkillSet> findByVacancy(Vacancy vacancy);
}
