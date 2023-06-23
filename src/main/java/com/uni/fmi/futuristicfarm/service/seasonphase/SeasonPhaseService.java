package com.uni.fmi.futuristicfarm.service.seasonphase;

import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;

import java.util.List;

public interface SeasonPhaseService {

    List<SeasonPhaseDto> returnALlSeasonPhases();

    SeasonPhaseDto findSeasonPhaseByPhaseName(String phaseName);
}
