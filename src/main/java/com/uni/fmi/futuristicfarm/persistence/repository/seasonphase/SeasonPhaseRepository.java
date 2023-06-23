package com.uni.fmi.futuristicfarm.persistence.repository.seasonphase;

import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SeasonPhaseRepository extends JpaRepository<SeasonPhase, Long> {

    Optional<SeasonPhase> findSeasonPhaseByPhaseName(String phaseName);
}
