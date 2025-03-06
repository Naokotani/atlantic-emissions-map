package com.emissions.industrialemissionsmap.repository;

import com.emissions.industrialemissionsmap.model.DataSet;
import com.emissions.industrialemissionsmap.model.Emitter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DataSetRepository extends JpaRepository<DataSet, Long> {
}
