package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.FuelDto;
import com.enr.carfueltracker.exceptions.NoCarFoundException;
import com.enr.carfueltracker.exceptions.NoCurrencyFoundException;
import com.enr.carfueltracker.exceptions.NoDistanceUnitFoundException;
import com.enr.carfueltracker.exceptions.NoVolumeUnitFoundException;
import com.enr.carfueltracker.jpa.entity.*;
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
    private final CarService carService;
    private final VolumeUnitService volumeUnitService;
    private final CurrencyService currencyService;
    private final DistanceUnitService distanceUnitService;

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

    public boolean addFuelToCar(FuelDto fuelDto) throws NoCarFoundException, NoCurrencyFoundException, NoVolumeUnitFoundException, NoDistanceUnitFoundException {
        CarEntity car = carService.getCarEntity(UUID.fromString(fuelDto.getCarId()));
        VolumeUnitEntity volumeUnit = volumeUnitService.getVolumeUnitFromId(fuelDto.getVolumeId());
        DistanceUnitEntity distanceUnitEntity = distanceUnitService.getDistanceUnitFromId(fuelDto.getDistanceId());
        CurrencyEntity currencyEntity = currencyService.getCurrencyFromId(fuelDto.getCurrencyId());

        FuelEntity fuelEntity = FuelEntity.builder()
                .car(car)
                .price(fuelDto.getPrice())
                .createdAt(fuelDto.getCreatedAt())
                .currency(currencyEntity)
                .distance(fuelDto.getDistance())
                .distanceUnit(distanceUnitEntity)
                .volume(fuelDto.getVolume())
                .volumeUnit(volumeUnit)
                .build();

        fuelRepository.save(fuelEntity);
        return true;
    }
}
