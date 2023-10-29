package com.enr.carfueltracker.jpa.entity;

import jakarta.persistence.*;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "fuel")
public class Fuel {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "distance")
    private Double distance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "distance_unit_id", referencedColumnName = "id")
    private DistanceUnit distanceUnit;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private Currency currency;

    @Column(name = "volume")
    private Double volume;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volume_unit_id", referencedColumnName = "id")
    private VolumeUnit volumeUnit;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private Car car;
}
