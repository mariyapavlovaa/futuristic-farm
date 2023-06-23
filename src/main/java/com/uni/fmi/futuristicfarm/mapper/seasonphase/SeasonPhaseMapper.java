package com.uni.fmi.futuristicfarm.mapper.seasonphase;

import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SeasonPhaseMapper {

    SeasonPhaseMapper MAPPER = Mappers.getMapper(SeasonPhaseMapper.class);

    SeasonPhase convertDtoToEntity(SeasonPhaseDto seasonPhaseDto);

    SeasonPhaseDto convertEntityToDto(SeasonPhase seasonPhase);
}
