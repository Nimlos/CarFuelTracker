package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.dto.FuelDto;
import jakarta.persistence.*;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "fuel")
@Builder
public class FuelEntity {

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
    private DistanceUnitEntity distanceUnit;

    @Column(name = "price")
    private Double price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_id", referencedColumnName = "id")
    private CurrencyEntity currency;

    @Column(name = "volume")
    private Double volume;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "volume_unit_id", referencedColumnName = "id")
    private VolumeUnitEntity volumeUnit;

    @ManyToOne
    @JoinColumn(name = "car_id", nullable = false)
    private CarEntity car;

    public FuelDto toDto() {
        return FuelDto.builder()
                .carId(car.getId().toString())
                .createdAt(createdAt)
                .distance(distance)
                .distanceId(distanceUnit.getId())
                .price(price)
                .currencyId(currency.getId())
                .volume(volume)
                .volumeId(volumeUnit.getId())
                .build();
    }
}
