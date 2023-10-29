package com.enr.carfueltracker.jpa.entity;

import com.enr.carfueltracker.enums.CurrencyEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "currency")
    private Fuel fuel;

    @Column(name = "unit")
    @Enumerated(EnumType.STRING)
    private CurrencyEnum unit;
}
