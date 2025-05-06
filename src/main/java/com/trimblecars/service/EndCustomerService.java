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
public class EndCustomerService {

    private final CarRepository carRepository;

    public List<Car> getAvailableCars() {
        log.info("Customer fetching available cars");
        return carRepository.findAll()
                .stream()
                .filter(car -> car.getStatus() == CarStatus.IDEAL)
                .toList();
    }
}