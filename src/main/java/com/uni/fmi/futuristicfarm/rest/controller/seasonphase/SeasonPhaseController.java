package com.uni.fmi.futuristicfarm.rest.controller.seasonphase;

import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;
import com.uni.fmi.futuristicfarm.service.seasonphase.SeasonPhaseService;
import com.uni.fmi.futuristicfarm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(Constants.API_V1 + Constants.SEASON_PHASE)
public class SeasonPhaseController {

    private final SeasonPhaseService seasonPhaseService;

    @Autowired
    public SeasonPhaseController(SeasonPhaseService seasonPhaseService) {
        this.seasonPhaseService = seasonPhaseService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SeasonPhaseDto> findAllSeasonPhases() {

        return seasonPhaseService.returnALlSeasonPhases();
    }

    @GetMapping(path = "/phase/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public SeasonPhaseDto findSeasonPhaseByName(@RequestParam String phaseName) {

        return seasonPhaseService.findSeasonPhaseByPhaseName(phaseName);
    }
}
