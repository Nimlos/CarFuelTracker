package com.enr.carfueltracker.jpa.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "car")
public class Car {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "car")
    private List<Fuel> fuelList;
}
