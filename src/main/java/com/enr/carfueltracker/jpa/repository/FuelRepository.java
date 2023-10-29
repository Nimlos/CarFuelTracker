package com.enr.carfueltracker.jpa.repository;

import com.enr.carfueltracker.jpa.entity.FuelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface FuelRepository extends JpaRepository<FuelEntity, UUID> {
}
