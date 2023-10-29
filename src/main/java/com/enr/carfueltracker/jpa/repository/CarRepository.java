package com.enr.carfueltracker.jpa.repository;

import com.enr.carfueltracker.jpa.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CarRepository extends JpaRepository<Car, UUID> {
}
