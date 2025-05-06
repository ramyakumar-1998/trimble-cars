package com.trimblecars;


import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.service.AdminService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testGetAllCars() {
        Car car = new Car(1L, "Model X", "Variant A", "123ABC", CarStatus.IDEAL, 1001L);
        Mockito.when(carRepository.findAll()).thenReturn(List.of(car));

        var cars = adminService.getAllCars();

        assertEquals(1, cars.size());
        assertEquals("Model X", cars.get(0).getModel());
    }

    @Test
    public void testUpdateCar() {
        Car car = new Car(1L, "Model X", "Variant A", "123ABC", CarStatus.IDEAL, 1001L);
        Mockito.when(carRepository.save(Mockito.any(Car.class))).thenReturn(car);

        Car updatedCar = adminService.updateCar(car);

        assertEquals("Model X", updatedCar.getModel());
        assertEquals(CarStatus.IDEAL, updatedCar.getStatus());
    }
}
