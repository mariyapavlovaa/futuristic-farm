package com.uni.fmi.futuristicfarm.persistence.repository.symptom;

import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illnesssymptom.Symptom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SymptomRepository extends JpaRepository<Symptom, Long> {
    Optional<Symptom> findByName(String name);
}
