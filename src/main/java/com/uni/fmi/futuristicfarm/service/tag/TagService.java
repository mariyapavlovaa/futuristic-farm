package com.uni.fmi.futuristicfarm.service.tag;

import com.uni.fmi.futuristicfarm.rest.dto.tag.TagDto;

import java.util.Set;

public interface TagService {

    Set<TagDto> findTags();

    TagDto findTagById(Long tagId);

    TagDto findTagByName(String name);

    TagDto findTagByAbbreviation(String abbreviation);

    TagDto createTag(TagDto tagDto);

    TagDto updateTag(Long tagId, TagDto tagDto);

    TagDto deleteTag(Long tagId);
}
