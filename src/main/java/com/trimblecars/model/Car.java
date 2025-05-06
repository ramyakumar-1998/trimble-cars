package com.trimblecars.model;


import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@Entity
@Data
@Builder
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String model;
    private String variant;
    private String registrationNumber;

    @Enumerated(EnumType.STRING)
    private CarStatus status;

    private Long ownerId;

    public Car(Long id, String model, String variant, String registrationNumber, CarStatus status, Long ownerId) {
        this.id = id;
        this.model = model;
        this.variant = variant;
        this.registrationNumber = registrationNumber;
        this.status = status;
        this.ownerId = ownerId;
    }
}
