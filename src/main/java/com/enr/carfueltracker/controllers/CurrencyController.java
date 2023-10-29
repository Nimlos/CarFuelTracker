package com.enr.carfueltracker.controllers;

import com.enr.carfueltracker.dto.CurrencyDto;
import com.enr.carfueltracker.services.CurrencyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping("/currencies")
    public List<CurrencyDto> getAllCurrencies() {
        return currencyService.getAllCurrencies();
    }


}
