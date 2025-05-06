package com.trimblecars.repository;


import com.trimblecars.model.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {

}
