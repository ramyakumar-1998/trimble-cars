package com.trimblecars.controller;

import com.trimblecars.model.Car;
import com.trimblecars.service.CarService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
@RequiredArgsConstructor
@Slf4j
public class CarOwnerController {

    private final CarService carService;

    @PostMapping("/cars")
    public ResponseEntity<Car> registerCar(@RequestBody Car car) {
        log.info("API Call - Register car");
        return ResponseEntity.ok(carService.registerCar(car));
    }

    @GetMapping("/cars/{ownerId}")
    public ResponseEntity<List<Car>> getCarsByOwner(@PathVariable Long ownerId) {
        log.info("API Call - Get cars by ownerId: {}", ownerId);
        return ResponseEntity.ok(carService.getCarsByOwnerId(ownerId));
    }
}