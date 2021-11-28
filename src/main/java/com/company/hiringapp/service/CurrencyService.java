package com.company.hiringapp.service;

import com.company.hiringapp.dto.CurrencyDTO;

import java.util.List;

public interface CurrencyService {
    List<CurrencyDTO> findAll();

    CurrencyDTO findById(Long id);

    CurrencyDTO findByCode(String code);

}
