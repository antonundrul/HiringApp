package com.company.hiringapp.repository;

import com.company.hiringapp.dto.UserDTO;
import com.company.hiringapp.entity.Experience;
import com.company.hiringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExperienceRepository extends JpaRepository<Experience,Long> {
    @Override
    Optional<Experience> findById(Long aLong);

    List<Experience> findByUser(User user);


}
