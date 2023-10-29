package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.dto.CurrencyDto;
import com.enr.carfueltracker.enums.CurrencyEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "currency")
@Data
public class CurrencyEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "currency")
    private FuelEntity fuelEntity;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum unit;

    public CurrencyDto toDto() {
        return new CurrencyDto(id, unit.getName());
    }
}
