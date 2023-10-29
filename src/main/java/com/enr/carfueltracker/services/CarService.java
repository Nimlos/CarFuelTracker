package com.enr.carfueltracker.services;

import com.enr.carfueltracker.dto.CarDto;
import com.enr.carfueltracker.exceptions.NoCarFoundException;
import com.enr.carfueltracker.jpa.entity.CarEntity;
import com.enr.carfueltracker.jpa.repository.CarRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class CarService {
    private final CarRepository carRepository;

    public ArrayList<CarDto> getAllCars() {
        ArrayList<CarDto> carList = new ArrayList<>();

        List<CarEntity> carEntityList = carRepository.findAll();
        carEntityList.forEach(carEntity -> {
            carList.add(carEntity.toCarDto());
        });

        return carList;
    }

    public void newCar(CarDto carDto) {
        CarEntity newCar = carDto.toEntity();
        carRepository.save(newCar);
    }

    public CarDto getCar(UUID id) throws NoCarFoundException {
        return getCarEntity(id).toCarDto();
    }

    public CarEntity getCarEntity(UUID id) throws NoCarFoundException {
        return carRepository.findById(id).orElseThrow(() -> new NoCarFoundException("Cannot find car with id: " + id));
    }
}
