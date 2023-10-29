package com.enr.carfueltracker.controllers;

import com.enr.carfueltracker.dto.DistanceUnitDto;
import com.enr.carfueltracker.services.DistanceUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DistanceUnitController {
    private final DistanceUnitService distanceUnitService;

    @GetMapping("/distance-units")
    public List<DistanceUnitDto> getAllDistanceUnits() {
        return distanceUnitService.getAllDistanceUnits();
    }
}
