package com.trimblecars;


import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.service.CarService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CarServiceTest {

    @InjectMocks
    private CarService carService;

    @Mock
    private CarRepository carRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegisterCar() {
        Car car = Car.builder().model("Tesla").status(CarStatus.IDEAL).build();
        when(carRepository.save(any(Car.class))).thenReturn(car);

        Car saved = carService.registerCar(car);
        assertEquals("Tesla", saved.getModel());
    }

    @Test
    void testGetAllCars() {
        when(carRepository.findAll()).thenReturn(Arrays.asList(new Car(), new Car()));
        List<Car> cars = carService.getAllCars();
        assertEquals(2, cars.size());
    }
}
