package com.enr.carfueltracker.controllers;

import com.enr.carfueltracker.dto.FuelDto;
import com.enr.carfueltracker.exceptions.NoCarFoundException;
import com.enr.carfueltracker.exceptions.NoCurrencyFoundException;
import com.enr.carfueltracker.exceptions.NoDistanceUnitFoundException;
import com.enr.carfueltracker.exceptions.NoVolumeUnitFoundException;
import com.enr.carfueltracker.services.FuelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class FuelController {

    private final FuelService fuelService;

    @GetMapping("/fuel/{carId}")
    public List<FuelDto> getFuelForCar(@PathVariable UUID carId) throws NoCarFoundException {
        return fuelService.getAllFuelForCar(carId);
    }


    @PostMapping("/fuel")
    public boolean addFuelToCar(@RequestBody FuelDto fuelDto) throws NoVolumeUnitFoundException, NoCurrencyFoundException, NoCarFoundException, NoDistanceUnitFoundException {
        return fuelService.addFuelToCar(fuelDto);
    }
}
