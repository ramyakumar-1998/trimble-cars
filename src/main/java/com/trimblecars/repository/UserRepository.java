package com.trimblecars.repository;


import com.trimblecars.model.Role;
import com.trimblecars.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByRole(Role role);
}
