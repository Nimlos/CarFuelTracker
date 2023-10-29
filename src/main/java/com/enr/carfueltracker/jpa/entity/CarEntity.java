package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.dto.CarDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "car")
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
public class CarEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private UUID id;

    @OneToMany(mappedBy = "car")
    private List<FuelEntity> fuelEntityList;

    public CarDto toCarDto() {
        return CarDto.builder().id(id.toString()).build();
    }
}
