package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.FuelDto;
import com.enr.carfueltracker.exceptions.NoCarFoundException;
import com.enr.carfueltracker.jpa.entity.CarEntity;
import com.enr.carfueltracker.jpa.entity.FuelEntity;
import com.enr.carfueltracker.jpa.repository.CarRepository;
import com.enr.carfueltracker.jpa.repository.FuelRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class FuelService {

    private final FuelRepository fuelRepository;
    private final CarRepository carRepository;

    public List<FuelDto> getAllFuelForCar(UUID carId) throws NoCarFoundException {
        ArrayList<FuelDto> fuelDtos = new ArrayList<>();

        CarEntity carEntity = carRepository.findById(carId).orElseThrow(() -> new NoCarFoundException(carId.toString()));

        List<FuelEntity> fuelEntities = carEntity.getFuelEntityList();

        fuelEntities.forEach(fuelEntity -> {
            fuelDtos.add(fuelEntity.toDto());
        });

        fuelDtos.sort(new Comparator<FuelDto>() {
            @Override
            public int compare(FuelDto o1, FuelDto o2) {
                return o2.getCreatedAt().compareTo(o1.getCreatedAt());
            }
        });

        return fuelDtos;
    }

//    public boolean addFuelToCar(FuelDto fuelDto) {
//
//    }
}
