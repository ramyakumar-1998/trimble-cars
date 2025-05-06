package com.trimblecars;

import com.trimblecars.model.Car;
import com.trimblecars.model.CarStatus;
import com.trimblecars.repository.CarRepository;
import com.trimblecars.service.LeaseService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LeaseServiceTest {

    @InjectMocks
    private LeaseService leaseService;

    @Mock
    private CarRepository carRepository;

    @Test
    public void testStartLease() {
        Car car = new Car(1L, "Model X", "Variant A", "123ABC", CarStatus.IDEAL, 1001L);
        Mockito.when(carRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(car));
        Mockito.when(carRepository.save(Mockito.any(Car.class))).thenReturn(car);

        Car leasedCar = leaseService.startLease(1L);

        assertEquals(CarStatus.ON_LEASE, leasedCar.getStatus());
    }

    @Test
    public void testEndLease() {
        Car car = new Car(1L, "Model X", "Variant A", "123ABC", CarStatus.IDEAL, 1001L);
        Mockito.when(carRepository.findById(Mockito.anyLong())).thenReturn(java.util.Optional.of(car));
        Mockito.when(carRepository.save(Mockito.any(Car.class))).thenReturn(car);

        Car returnedCar = leaseService.endLease(1L);

        assertEquals(CarStatus.IDEAL, returnedCar.getStatus());
    }
}
