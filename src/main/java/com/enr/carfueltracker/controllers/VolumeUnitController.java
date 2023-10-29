package com.enr.carfueltracker.controllers;

import com.enr.carfueltracker.dto.VolumeUnitDto;
import com.enr.carfueltracker.services.VolumeUnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class VolumeUnitController {
    private final VolumeUnitService volumeUnitService;

    @GetMapping("/volume-units")
    public List<VolumeUnitDto> getAllVolumes() {
        return volumeUnitService.getAllVolumeUnits();
    }
}
