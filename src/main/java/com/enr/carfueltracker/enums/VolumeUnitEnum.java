package com.enr.carfueltracker.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum VolumeUnitEnum {
    LITER("liter"),
    GALLONS("gallons");

    private final String name;
    
    public VolumeUnitEnum fromName(String name) throws IllegalArgumentException{
        for (VolumeUnitEnum volumeUnitEnum : VolumeUnitEnum.values()) {
            if (volumeUnitEnum.getName().equals(name)) {
                return volumeUnitEnum;
            }
        }
        throw new IllegalArgumentException("Cannot find enum with name: " + name);
    }  
}
