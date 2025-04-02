package com.emissions.industrialemissionsmap.repository;

import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface EmitterRepository extends JpaRepository<Emitter, Integer> {
    List<Emitter> findAllByYearAndFacilityProvinceTerritoryAndDataSet(int year, String facilityProvinceTerritory, DataSet activeDataSet);
    @Query("SELECT e.ghgrpId, " +
            "SUM(e.totalEmissionsTonnes), " +
            "SUM(e.co2Tonnes), " +
            "SUM(e.ch4Co2TonnesEquivalent), " +
            "SUM(e.n2oCo2TonnesEquivalent)," +
            "SUM(e.sf6Co2TonnesEquivalent)," +
            "SUM(e.pfcTotalCo2Tonnes)," +
            "SUM(e.hfc32Co2TonnesEquivalent), " +
            "SUM(e.hfc41Co2TonnesEquivalent), " +
            "SUM(e.hfc4310meeCo2TonnesEquivalent), " +
            "SUM(e.hfc125Co2TonnesEquivalent), " +
            "SUM(e.hfc134Co2TonnesEquivalent), " +
            "SUM(e.hfc134aCo2TonnesEquivalent), " +
            "SUM(e.hfc143Co2TonnesEquivalent), " +
            "SUM(e.hfc143aCo2TonnesEquivalent), " +
            "SUM(e.hfc152aCo2TonnesEquivalent), " +
            "SUM(e.hfc227eaCo2TonnesEquivalent), " +
            "SUM(e.hfc236faCo2TonnesEquivalent), " +
            "SUM(e.hfc245caCo2TonnesEquivalent) " +
            "FROM Emitter e " +
            "WHERE e.year IN :years AND e.dataSet = :activeDataSet " +
            "AND e.facilityProvinceTerritory = :facilityProvinceTerritory " +
            "GROUP BY e.ghgrpId")
    List<Object[]> sumYearsByFacilityProvinceTerritory(List<Integer> years, String facilityProvinceTerritory, DataSet activeDataSet);
    Optional<Emitter> findEmitterByFacilityNameAndYearAndDataSet(String name, int year, DataSet activeDataset);
    Optional<List<Emitter>> findEmittersByReportingCompanyBusinessNumberAndDataSet(int businessNumber, DataSet activeDataset);
    Optional<List<Emitter>> findAllByFacilityNameAndDataSet(String facilityName, DataSet activeataset);
    Optional<List<Emitter>> findEmitterByGhgrpIdAndDataSet(String ghgrpId, DataSet activeDataSet);
}
