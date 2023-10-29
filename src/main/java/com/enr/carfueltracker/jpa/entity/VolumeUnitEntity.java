package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.dto.VolumeUnitDto;
import com.enr.carfueltracker.enums.VolumeUnitEnum;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "volume_unit")
@Data
public class VolumeUnitEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "volumeUnit")
    private FuelEntity fuelEntity;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private VolumeUnitEnum unit;

    public VolumeUnitDto toDto() {
        return new VolumeUnitDto(id, unit.getName());
    }
}
