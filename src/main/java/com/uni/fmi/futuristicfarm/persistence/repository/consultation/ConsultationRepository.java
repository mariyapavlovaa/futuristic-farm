package com.uni.fmi.futuristicfarm.persistence.repository.consultation;

import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.consultation.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
}
