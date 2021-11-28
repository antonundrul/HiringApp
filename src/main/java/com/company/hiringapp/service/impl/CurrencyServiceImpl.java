package com.company.hiringapp.service.impl;

import com.company.hiringapp.dto.CurrencyDTO;
import com.company.hiringapp.dto.mapper.CurrencyMapper;
import com.company.hiringapp.entity.Currency;
import com.company.hiringapp.exception.ResourceNotFoundException;
import com.company.hiringapp.repository.CurrencyRepository;
import com.company.hiringapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CurrencyServiceImpl implements CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;
    @Autowired
    private CurrencyMapper currencyMapper;

    @Override
    public List<CurrencyDTO> findAll() {
        return currencyMapper.toDtoList(currencyRepository.findAll());
    }

    @Override
    public CurrencyDTO findById(Long id) {

        Currency currency = currencyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        return currencyMapper.toDto(currency);
    }

    @Override
    public CurrencyDTO findByCode(String code) {
        return currencyMapper.toDto(currencyRepository.findByCode(code));
    }
}
