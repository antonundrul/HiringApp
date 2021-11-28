package com.company.hiringapp.dto.mapper;

import com.company.hiringapp.dto.CurrencyDTO;
import com.company.hiringapp.entity.Currency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CurrencyMapper extends AbstractMapper<Currency, CurrencyDTO>{
    @Autowired
    public CurrencyMapper(){super(Currency.class,CurrencyDTO.class);}
}
