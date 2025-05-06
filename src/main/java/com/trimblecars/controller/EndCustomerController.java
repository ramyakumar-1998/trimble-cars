package com.trimblecars.controller;

import com.trimblecars.model.Car;
import com.trimblecars.model.LeaseHistory;
import com.trimblecars.service.CarService;
import com.trimblecars.service.EndCustomerService;
import com.trimblecars.service.LeaseHistoryService;
import com.trimblecars.service.LeaseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
@RequiredArgsConstructor
@Slf4j
public class EndCustomerController {

    private final CarService carService;
    private final EndCustomerService endCustomerService;
    private final LeaseService leaseService;
    private final LeaseHistoryService leaseHistoryService;

    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAvailableCars() {
        log.info("Fetching all available cars for lease");
        List<Car> allCars = carService.getAllCars();
        return ResponseEntity.ok(allCars);
    }

    @PostMapping("/lease/{carId}")
    public ResponseEntity<Car> startLease(@PathVariable Long carId) {
        Car leasedCar = leaseService.startLease(carId);
        return new ResponseEntity<>(leasedCar, HttpStatus.CREATED);
    }

    @PostMapping("/lease/end/{carId}")
    public ResponseEntity<Car> endLease(@PathVariable Long carId) {
        Car returnedCar = leaseService.endLease(carId);
        return new ResponseEntity<>(returnedCar, HttpStatus.OK);
    }

    @GetMapping("/cars/status")
    public ResponseEntity<List<Car>> getCarsWithStatus() {
        List<Car> allCars = endCustomerService.getAvailableCars();
        return new ResponseEntity<>(allCars, HttpStatus.OK);
    }

    @GetMapping("/lease/history/{userId}")
    public ResponseEntity<List<LeaseHistory>> getLeaseHistory(@PathVariable Long userId) {
        List<LeaseHistory> leaseHistory = leaseHistoryService.getHistoryByUserId(userId);
        return new ResponseEntity<>(leaseHistory, HttpStatus.OK);
    }
}