package com.company.hiringapp.repository;

import com.company.hiringapp.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
    @Override
    Optional<Currency> findById(Long id);

    Currency findByCode(String code);
}
