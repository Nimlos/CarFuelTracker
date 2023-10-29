package com.enr.carfueltracker.jpa.repository;

import com.enr.carfueltracker.jpa.entity.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Integer> {
}
