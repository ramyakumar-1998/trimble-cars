package com.trimblecars.controller;


import com.trimblecars.model.Car;
import com.trimblecars.model.LeaseHistory;
import com.trimblecars.model.User;
import com.trimblecars.service.AdminService;
import com.trimblecars.service.LeaseHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;
    private final LeaseHistoryService leaseHistoryService;


    @GetMapping("/cars")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> cars = adminService.getAllCars();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable Long id, @RequestBody Car car) {
        car.setId(id);
        Car updatedCar = adminService.updateCar(car);
        return new ResponseEntity<>(updatedCar, HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long id) {
        adminService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/owners")
    public ResponseEntity<List<User>> getAllCarOwners() {
        List<User> carOwners = adminService.getAllCarOwners();
        return new ResponseEntity<>(carOwners, HttpStatus.OK);
    }

    @GetMapping("/owners/{id}")
    public ResponseEntity<User> getCarOwnerById(@PathVariable Long id) {
        User carOwner = adminService.getCarOwnerById(id);
        return new ResponseEntity<>(carOwner, HttpStatus.OK);
    }

    @PutMapping("/owners/{id}")
    public ResponseEntity<User> updateCarOwner(@PathVariable Long id, @RequestBody User carOwner) {
        carOwner.setId(id);
        User updatedCarOwner = adminService.updateCarOwner(carOwner);
        return new ResponseEntity<>(updatedCarOwner, HttpStatus.OK);
    }

    @DeleteMapping("/owners/{id}")
    public ResponseEntity<Void> deleteCarOwner(@PathVariable Long id) {
        adminService.deleteCarOwner(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/customers")
    public ResponseEntity<List<User>> getAllEndCustomers() {
        List<User> endCustomers = adminService.getAllEndCustomers();
        return new ResponseEntity<>(endCustomers, HttpStatus.OK);
    }

    @GetMapping("/customers/{id}")
    public ResponseEntity<User> getEndCustomerById(@PathVariable Long id) {
        User endCustomer = adminService.getEndCustomerById(id);
        return new ResponseEntity<>(endCustomer, HttpStatus.OK);
    }

    @PutMapping("/customers/{id}")
    public ResponseEntity<User> updateEndCustomer(@PathVariable Long id, @RequestBody User endCustomer) {
        endCustomer.setId(id);
        User updatedEndCustomer = adminService.updateEndCustomer(id, endCustomer);
        return new ResponseEntity<>(updatedEndCustomer, HttpStatus.OK);
    }

    @DeleteMapping("/customers/{id}")
    public ResponseEntity<Void> deleteEndCustomer(@PathVariable Long id) {
        adminService.deleteEndCustomer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/lease/history")
    public ResponseEntity<List<LeaseHistory>> getAllLeaseHistory() {
        List<LeaseHistory> leaseHistoryList = leaseHistoryService.getAllLeaseHistory();
        return new ResponseEntity<>(leaseHistoryList, HttpStatus.OK);
    }

    @GetMapping("/lease/history/{userId}")
    public ResponseEntity<List<LeaseHistory>> getLeaseHistoryByUserId(@PathVariable Long userId) {
        List<LeaseHistory> leaseHistoryList = leaseHistoryService.getHistoryByUserId(userId);
        return new ResponseEntity<>(leaseHistoryList, HttpStatus.OK);
    }

    @PostMapping("/lease")
    public ResponseEntity<LeaseHistory> addLeaseHistory(@RequestBody LeaseHistory leaseHistory) {
        LeaseHistory savedLeaseHistory = leaseHistoryService.saveHistory(leaseHistory);
        return new ResponseEntity<>(savedLeaseHistory, HttpStatus.CREATED);
    }

    @DeleteMapping("/lease/{id}")
    public ResponseEntity<Void> deleteLeaseHistory(@PathVariable Long id) {
        leaseHistoryService.deleteLeaseHistory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
