package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Resume;
import com.company.hiringapp.entity.ResumeSkillSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResumeSkillSetRepository extends JpaRepository<ResumeSkillSet,Long> {
    List<ResumeSkillSet> findByResume(Resume resume);


}
