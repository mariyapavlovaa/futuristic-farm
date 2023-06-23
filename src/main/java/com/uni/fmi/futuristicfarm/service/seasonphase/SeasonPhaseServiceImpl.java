package com.uni.fmi.futuristicfarm.service.seasonphase;

import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapper;
import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import com.uni.fmi.futuristicfarm.persistence.repository.seasonphase.SeasonPhaseRepository;
import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SeasonPhaseServiceImpl implements SeasonPhaseService {

    private final SeasonPhaseRepository seasonPhaseRepository;
    private final SeasonPhaseMapper seasonPhaseMapper;

    @Autowired
    public SeasonPhaseServiceImpl(SeasonPhaseRepository seasonPhaseRepository) {
        this.seasonPhaseRepository = seasonPhaseRepository;
        this.seasonPhaseMapper = new SeasonPhaseMapperImpl();
    }

    @Override
    public List<SeasonPhaseDto> returnALlSeasonPhases() {

        List<SeasonPhase> seasons = seasonPhaseRepository.findAll();

        return seasons
                .stream()
                .map(seasonPhaseMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public SeasonPhaseDto findSeasonPhaseByPhaseName(String name) {

        SeasonPhase seasonPhase = seasonPhaseRepository.findSeasonPhaseByPhaseName(name)
                .orElseThrow(() -> new IllegalArgumentException("Season Phase could not be found with such name!"));

        return seasonPhaseMapper.convertEntityToDto(seasonPhase);
    }
}
