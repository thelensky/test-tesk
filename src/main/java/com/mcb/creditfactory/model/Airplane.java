package com.mcb.creditfactory.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "AIRPLANE")
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private String manufacturer;
    private Integer seats;

    @Column(name = "year_of_issue")
    private Short year;

    @Column(name = "fuel_capacity")
    private Double fuelCapacity;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Collaterals collaterals;
}
