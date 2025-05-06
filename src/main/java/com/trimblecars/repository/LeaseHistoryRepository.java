package com.trimblecars.repository;


import com.trimblecars.model.LeaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseHistoryRepository extends JpaRepository<LeaseHistory, Long> {
    List<LeaseHistory> findByUserId(Long userId);
}
