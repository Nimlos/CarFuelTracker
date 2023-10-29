package com.enr.carfueltracker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum DistanceUnitEnum {
    MILES("miles"),
    KILOMETER("kilometer");

    private final String name;

    public DistanceUnitEnum fromName(String name) throws IllegalArgumentException {
        for (DistanceUnitEnum distanceUnitEnum : DistanceUnitEnum.values()) {
            if (distanceUnitEnum.getName().equals(name)) {
                return distanceUnitEnum;
            }
        }
        throw new IllegalArgumentException("Cannot find enum with name: " + name);
    }
}
