package com.emissions.industrialemissionsmap.repository;

import com.emissions.industrialemissionsmap.model.Emitter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmitterRepository extends JpaRepository<Emitter, Integer> {
}
