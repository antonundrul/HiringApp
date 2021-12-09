package com.company.hiringapp.repository;

import com.company.hiringapp.dto.CityDTO;
import com.company.hiringapp.entity.City;
import com.company.hiringapp.entity.Resume;
import com.company.hiringapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResumeRepository extends JpaRepository<Resume,Long>
{
    @Override
    Optional<Resume> findById(Long id);

    List<Resume> findByCity(City city);

    Resume findByUser(User user);

}
