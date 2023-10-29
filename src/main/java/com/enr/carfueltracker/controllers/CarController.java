package com.enr.carfueltracker.controllers;

import com.enr.carfueltracker.dto.CarDto;
import com.enr.carfueltracker.exceptions.NoCarFoundException;
import com.enr.carfueltracker.services.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @GetMapping("/car")
    List<CarDto> getAllCars() {
        return carService.getAllCars();
    }

    @PostMapping("/car")
    boolean newCar(@RequestBody CarDto carDto) {
        carService.newCar(carDto);
        return true;
    }

    @GetMapping("/car/{id}")
    public CarDto getCar(@PathVariable UUID id) throws NoCarFoundException {
        return carService.getCar(id);
    }
}
