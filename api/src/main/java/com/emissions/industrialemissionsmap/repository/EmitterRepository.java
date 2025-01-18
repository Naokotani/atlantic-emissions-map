package com.emissions.industrialemissionsmap.repository;

import com.emissions.industrialemissionsmap.model.Emitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmitterRepository extends JpaRepository<Emitter, Integer> {
    List<Emitter> findAllByYearAndFacilityProvinceTerritory(int year, String facilityProvinceTerritory);
    Optional<Emitter> findEmitterByFacilityNameAndYear(String name, int year);
    Optional<List<Emitter>> findEmittersByReportingCompanyBusinessNumber(int businessNumber);
    Optional<List<Emitter>> findAllByFacilityName(String facilityName);
}
