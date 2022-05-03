package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LevelRepository extends JpaRepository<Level,Long> {
    @Override
    Optional<Level> findById(Long id);

    Level findByName(String name);
}
