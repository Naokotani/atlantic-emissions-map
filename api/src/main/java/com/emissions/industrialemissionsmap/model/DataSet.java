package com.emissions.industrialemissionsmap.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DataSet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dataSetId;
    private int currentYear;
    private int records;
    private boolean active;
    private LocalDateTime uploaded;
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Integer> years;
    @OneToMany(fetch = FetchType.LAZY, orphanRemoval = true,  cascade = CascadeType.ALL)
    private Set<Emitter> emitters;
}
