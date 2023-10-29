package com.enr.carfueltracker.jpa.repository;

import com.enr.carfueltracker.jpa.entity.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}
