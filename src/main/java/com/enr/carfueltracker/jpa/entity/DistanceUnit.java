package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.enums.DistanceUnitEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "distance_unit")
public class DistanceUnit {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "distanceUnit")
    private Fuel fuel;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private DistanceUnitEnum unit;
}
