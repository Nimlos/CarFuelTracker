package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.VolumeUnitDto;
import com.enr.carfueltracker.jpa.repository.VolumeUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VolumeUnitService {

    private final VolumeUnitRepository volumeUnitRepository;

    public List<VolumeUnitDto> getAllVolumeUnits() {
        ArrayList<VolumeUnitDto> volumeUnitDtos = new ArrayList<>();

        volumeUnitRepository.findAll().forEach(volumeUnitEntity -> {
            volumeUnitDtos.add(volumeUnitEntity.toDto());
        });

        return volumeUnitDtos;
    }
}
