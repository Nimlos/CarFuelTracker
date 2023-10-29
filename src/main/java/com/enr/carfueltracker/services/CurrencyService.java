package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.CurrencyDto;
import com.enr.carfueltracker.exceptions.NoCurrencyFoundException;
import com.enr.carfueltracker.jpa.entity.CurrencyEntity;
import com.enr.carfueltracker.jpa.repository.CurrencyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CurrencyService {
    private final CurrencyRepository currencyRepository;

    public List<CurrencyDto> getAllCurrencies() {
        ArrayList<CurrencyDto> currencyDtos = new ArrayList<>();

        currencyRepository.findAll().forEach(currencyEntity -> {
            currencyDtos.add(currencyEntity.toDto());
        });

        return currencyDtos;
    }

    public CurrencyEntity getCurrencyFromId(Integer id) throws NoCurrencyFoundException {
        return currencyRepository.findById(id).orElseThrow(() -> new NoCurrencyFoundException(Integer.toString(id)));
    }
}
