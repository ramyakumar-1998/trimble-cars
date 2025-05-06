package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaseService {

    private final CarRepository carRepository;

    public Car startLease(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        if (car.getStatus() != CarStatus.IDEAL) {
            throw new RuntimeException("Car is not available for lease");
        }
        car.setStatus(CarStatus.ON_LEASE);
        return carRepository.save(car);
    }

    public Car endLease(Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car not found"));
        car.setStatus(CarStatus.IDEAL);
        return carRepository.save(car);
    }
}