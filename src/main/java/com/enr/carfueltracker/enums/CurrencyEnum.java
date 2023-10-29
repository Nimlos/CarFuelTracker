package com.enr.carfueltracker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum CurrencyEnum {

    DKK("dkk"),
    USD("dollars");

    private final String name;

    public CurrencyEnum fromName(String name) throws IllegalArgumentException {
        for(CurrencyEnum currencyEnum : CurrencyEnum.values()) {
            if (currencyEnum.getName().equals(name)) {
                return currencyEnum;
            }
        }
        throw new IllegalArgumentException("Cannot find enum with name: " + name);
    }
}
