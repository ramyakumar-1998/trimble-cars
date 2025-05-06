package com.trimblecars.controller;

import com.trimblecars.model.LeaseHistory;
import com.trimblecars.service.LeaseHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
@Slf4j
public class LeaseHistoryController {

    private final LeaseHistoryService leaseHistoryService;

    @GetMapping("/{userId}")
    public ResponseEntity<List<LeaseHistory>> getHistory(@PathVariable Long userId) {
        return ResponseEntity.ok(leaseHistoryService.getHistoryByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<LeaseHistory> saveHistory(@RequestBody LeaseHistory leaseHistory) {
        return ResponseEntity.ok(leaseHistoryService.saveHistory(leaseHistory));
    }
}