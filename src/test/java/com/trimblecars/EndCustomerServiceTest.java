package com.trimblecars;


import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.service.EndCustomerService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class EndCustomerServiceTest {

    @InjectMocks
    private EndCustomerService endCustomerService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testGetAvailableCars() {
        Car car = new Car(1L, "Model X", "Variant A", "123ABC", CarStatus.IDEAL, 1001L);
        Mockito.when(carRepository.findAll()).thenReturn(List.of(car));

        var availableCars = endCustomerService.getAvailableCars();

        assertEquals(1, availableCars.size());
        assertEquals("Model X", availableCars.get(0).getModel());
        assertEquals(CarStatus.IDEAL, availableCars.get(0).getStatus());
    }
}
