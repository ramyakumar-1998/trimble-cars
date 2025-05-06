package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarService {

    private final CarRepository carRepository;

    public Car registerCar(Car car) {
        log.info("Registering car: {}", car);
        car.setStatus(CarStatus.IDEAL);
        return carRepository.save(car);
    }

    public List<Car> getAllCars() {
        log.info("Fetching all cars");
        return carRepository.findAll();
    }

    public List<Car> getCarsByOwnerId(Long ownerId) {
        log.info("Fetching cars for ownerId: {}", ownerId);
        return carRepository.findByOwnerId(ownerId);
    }


}
