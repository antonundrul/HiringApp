package com.company.hiringapp.repository;

import com.company.hiringapp.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City,Long> {
    @Override
    Optional<City> findById(Long id);

    City findByName(String name);
}
