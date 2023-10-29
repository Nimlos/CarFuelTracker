package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.dto.DistanceUnitDto;
import com.enr.carfueltracker.enums.DistanceUnitEnum;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "distance_unit")
@Getter
public class DistanceUnitEntity {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "distanceUnit")
    private FuelEntity fuelEntity;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private DistanceUnitEnum unit;

    public DistanceUnitDto toDto() {
        return new DistanceUnitDto(id, unit.getName());
    }
}
