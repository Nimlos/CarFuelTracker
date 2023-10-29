package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.DistanceUnitDto;
import com.enr.carfueltracker.exceptions.NoDistanceUnitFoundException;
import com.enr.carfueltracker.jpa.entity.DistanceUnitEntity;
import com.enr.carfueltracker.jpa.repository.DistanceUnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DistanceUnitService {
    private final DistanceUnitRepository distanceUnitRepository;

    public List<DistanceUnitDto> getAllDistanceUnits() {
        List<DistanceUnitEntity> distanceUnitEntityList = distanceUnitRepository.findAll();
        ArrayList<DistanceUnitDto> distanceUnitDtos = new ArrayList<>();

        distanceUnitEntityList.forEach((distanceUnitEntity -> {
            distanceUnitDtos.add(distanceUnitEntity.toDto());
        }));

        return distanceUnitDtos;
    }

    public DistanceUnitEntity getDistanceUnitFromId(Integer id) throws NoDistanceUnitFoundException {
        return distanceUnitRepository.findById(id).orElseThrow(() -> new NoDistanceUnitFoundException(Integer.toString(id)));
    }
}
