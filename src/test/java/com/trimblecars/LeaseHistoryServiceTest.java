package com.trimblecars;


import com.trimblecars.model.LeaseHistory;
import com.trimblecars.repository.LeaseHistoryRepository;
import com.trimblecars.service.LeaseHistoryService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LeaseHistoryServiceTest {

    @InjectMocks
    private LeaseHistoryService leaseHistoryService;

    @Mock
    private LeaseHistoryRepository leaseHistoryRepository;

    @Test
    public void testGetHistoryByUserId() {
        LeaseHistory leaseHistory = new LeaseHistory(1L, 1L, 1L, "2025-01-01", "2025-01-15", "Completed");
        Mockito.when(leaseHistoryRepository.findByUserId(Mockito.anyLong())).thenReturn(List.of(leaseHistory));

        var history = leaseHistoryService.getHistoryByUserId(1L);

        assertEquals(1, history.size());
        assertEquals("Completed", history.get(0).getStatus());
    }

    @Test
    public void testSaveHistory() {
        LeaseHistory leaseHistory = new LeaseHistory(1L, 1L, 1L, "2025-01-01", "2025-01-15", "Completed");
        Mockito.when(leaseHistoryRepository.save(Mockito.any(LeaseHistory.class))).thenReturn(leaseHistory);

        LeaseHistory savedHistory = leaseHistoryService.saveHistory(leaseHistory);

        assertEquals("Completed", savedHistory.getStatus());
    }
}
