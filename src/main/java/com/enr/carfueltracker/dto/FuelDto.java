package com.enr.carfueltracker.dto;

import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class FuelDto {
    private String carId;
    private Double distance;
    private Integer distanceId;
    private Double price;
    private Integer currencyId;
    private Double volume;
    private Integer volumeId;
    @JsonSetter(nulls = Nulls.SKIP)
    private Instant createdAt = Instant.now();
}
