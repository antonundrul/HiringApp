package com.company.hiringapp.dto.converter;

import com.company.hiringapp.dto.CurrencyDTO;
import com.company.hiringapp.service.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class CurrencyDTOConverter implements Converter<String, CurrencyDTO> {

    @Autowired
    private CurrencyService currencyService;

    @Override
    public CurrencyDTO convert(String id) {
        return currencyService.findById(Long.parseLong(id));
    }
}
