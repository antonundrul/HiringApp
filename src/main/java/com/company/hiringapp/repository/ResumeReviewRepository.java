package com.company.hiringapp.repository;

import com.company.hiringapp.entity.City;
import com.company.hiringapp.entity.Recruiter;
import com.company.hiringapp.entity.Resume;
import com.company.hiringapp.entity.ResumeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeReviewRepository extends JpaRepository<ResumeReview,Long> {
    @Override
    Optional<ResumeReview> findById(Long id);

    List<ResumeReview> findByResume(Resume resume);

    List<ResumeReview> findByRecruiter(Recruiter recruiter);
}
