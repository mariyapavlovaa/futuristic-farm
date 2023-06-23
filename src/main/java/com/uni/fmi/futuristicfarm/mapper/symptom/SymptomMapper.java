package com.uni.fmi.futuristicfarm.mapper.symptom;

import com.uni.fmi.futuristicfarm.persistence.entity.farmconsultation.illnesssymptom.Symptom;
import com.uni.fmi.futuristicfarm.rest.dto.symptom.SymptomDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SymptomMapper {

    SymptomMapper MAPPER = Mappers.getMapper(SymptomMapper.class);

    @Mapping(target = "deleted", ignore = true)
    Symptom convertDtoToEntity(SymptomDto symptomDto);

    SymptomDto convertEntityToDto(Symptom symptom);
}
