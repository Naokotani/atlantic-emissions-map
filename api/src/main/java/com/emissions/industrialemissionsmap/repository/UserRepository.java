package com.emissions.industrialemissionsmap.repository;

import com.emissions.industrialemissionsmap.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByName(String name);
}
