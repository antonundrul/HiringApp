package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Recruiter;
import com.company.hiringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecruiterRepository extends JpaRepository<Recruiter,Long> {
    Recruiter findByUser(User user);
}
