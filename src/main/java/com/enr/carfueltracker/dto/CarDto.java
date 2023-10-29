package com.enr.carfueltracker.dto;

import com.enr.carfueltracker.jpa.entity.CarEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Data
public class CarDto {

    private String id;

    public CarEntity toEntity() {
        return CarEntity.builder().id(UUID.fromString(id)).build();
    }
}
