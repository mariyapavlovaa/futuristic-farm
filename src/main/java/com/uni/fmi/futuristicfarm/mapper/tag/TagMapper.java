package com.uni.fmi.futuristicfarm.mapper.tag;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.tag.Tag;
import com.uni.fmi.futuristicfarm.rest.dto.tag.TagDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TagMapper {

    TagMapper MAPPER = Mappers.getMapper(TagMapper.class);

    Tag convertDtoToEntity(TagDto tageDto);

    TagDto convertEntityToDto(Tag tag);
}
