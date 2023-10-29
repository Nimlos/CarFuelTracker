package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.enums.VolumeUnitEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "volume_unit")
public class VolumeUnit {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "volumeUnit")
    private Fuel fuel;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private VolumeUnitEnum unit;
}
