package com.trimblecars.service;

import com.trimblecars.model.Car;
import com.trimblecars.model.LeaseHistory;
import com.trimblecars.model.Role;
import com.trimblecars.model.User;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.repository.LeaseHistoryRepository;
import com.trimblecars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AdminService {

    private final CarRepository carRepository;

    private final UserRepository userRepository;

    public List<Car> getAllCars() {
        log.info("Admin fetching all cars");
        return carRepository.findAll();
    }

    public Car updateCar(Car car) {
        log.info("Admin updating car: {}", car);
        return carRepository.save(car);
    }

    public void deleteCar(Long carId) {
        log.info("Admin deleting car with ID: {}", carId);
        carRepository.deleteById(carId);
    }

    public List<User> getAllCarOwners() {
        log.info("Admin fetching all Car Owners");
        return userRepository.findByRole(Role.CAR_OWNER);
    }

    public List<User> getAllEndCustomers() {
        log.info("Admin fetching all End Customers");
        return userRepository.findByRole(Role.END_CUSTOMER);
    }

    public User getEndCustomerById(Long userId) {
        log.info("Admin fetching End Customer with ID: {}", userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (user.getRole() != Role.END_CUSTOMER) {
            throw new RuntimeException("The user is not an End Customer");
        }
        return user;
    }

    public User updateEndCustomer(Long userId, User updatedUser) {
        log.info("Admin updating End Customer with ID: {}", userId);
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (existingUser.getRole() != Role.END_CUSTOMER) {
            throw new RuntimeException("The user is not an End Customer");
        }
        existingUser.setName(updatedUser.getName());
        existingUser.setEmail(updatedUser.getEmail());
        return userRepository.save(existingUser);
    }

    public void deleteEndCustomer(Long userId) {
        log.info("Admin deleting End Customer with ID: {}", userId);
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (existingUser.getRole() != Role.END_CUSTOMER) {
            throw new RuntimeException("The user is not an End Customer");
        }
        userRepository.delete(existingUser);
        log.info("End Customer with ID {} has been deleted", userId);
    }

    public User getCarOwnerById(Long id) {
        log.info("Fetching Car Owner with ID: {}", id);
        Optional<User> carOwner = userRepository.findById(id);
        if (carOwner.isPresent()) {
            return carOwner.get();
        } else {
            log.warn("Car Owner with ID: {} not found", id);
            throw new RuntimeException("Car Owner not found");
        }
    }

    public User updateCarOwner(User carOwner) {
        log.info("Updating Car Owner: {}", carOwner);
        return userRepository.save(carOwner);
    }

    public void deleteCarOwner(Long id) {
        log.info("Deleting Car Owner with ID: {}", id);
        userRepository.deleteById(id);
    }



}