package com.uni.fmi.futuristicfarm.persistence.repository.diagnose;

import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.diagnose.Diagnose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiagnoseRepository extends JpaRepository<Diagnose, Long> {
}
