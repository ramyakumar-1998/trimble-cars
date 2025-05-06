package com.trimblecars.service;

import com.trimblecars.model.LeaseHistory;
import com.trimblecars.repository.LeaseHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class LeaseHistoryService {

    private final LeaseHistoryRepository leaseHistoryRepository;

    public List<LeaseHistory> getAllLeaseHistory() {
        log.info("Fetching all lease history records");
        return leaseHistoryRepository.findAll();
    }

    public List<LeaseHistory> getHistoryByUserId(Long userId) {
        log.info("Fetching lease history for user with ID: {}", userId);
        List<LeaseHistory> leaseHistoryList = leaseHistoryRepository.findByUserId(userId);

        if (leaseHistoryList.isEmpty()) {
            log.warn("No lease history found for user with ID: {}", userId);
        }

        return leaseHistoryList;
    }

    public LeaseHistory saveHistory(LeaseHistory leaseHistory) {
        log.info("Saving lease history record: {}", leaseHistory);
        return leaseHistoryRepository.save(leaseHistory);
    }

    public void deleteLeaseHistory(Long leaseHistoryId) {
        log.info("Deleting lease history record with ID: {}", leaseHistoryId);
        LeaseHistory leaseHistory = leaseHistoryRepository.findById(leaseHistoryId)
                .orElseThrow(() -> new RuntimeException("Lease history not found"));
        leaseHistoryRepository.delete(leaseHistory);
        log.info("Lease history record with ID {} has been deleted", leaseHistoryId);
    }
}
