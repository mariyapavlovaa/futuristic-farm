package com.uni.fmi.futuristicfarm.service.tag;

import com.uni.fmi.futuristicfarm.mapper.tag.TagMapper;
import com.uni.fmi.futuristicfarm.mapper.tag.TagMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.tag.Tag;
import com.uni.fmi.futuristicfarm.persistence.repository.tag.TagRepository;
import com.uni.fmi.futuristicfarm.rest.dto.tag.TagDto;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final TagMapper tagMapper;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
        this.tagMapper = new TagMapperImpl();
    }

    @Override
    public Set<TagDto> findTags() {

        return tagRepository.findAll()
                .stream()
                .map(tagMapper::convertEntityToDto)
                .collect(Collectors.toSet());
    }

    @Override
    public TagDto findTagById(Long tagId) {
        Tag tag = tagRepository.findById(tagId).orElse(null);
        return tagMapper.convertEntityToDto(tag);
    }

    @Override
    public TagDto findTagByName(String name) {
        Tag tag = tagRepository.findByName(name).orElse(null);
        return tagMapper.convertEntityToDto(tag);
    }

    @Override
    public TagDto findTagByAbbreviation(String abbreviation) {
        Tag tag = tagRepository.findByName(abbreviation).orElse(null);
        return tagMapper.convertEntityToDto(tag);
    }

    @Override
    public TagDto createTag(TagDto tagDto) {

        if (tagDto == null) {
            throw new IllegalArgumentException("TagDto can't be null!");
        }

        Tag tagEntity = tagMapper.convertDtoToEntity(tagDto);
        tagEntity.setName(tagDto.getName());
        tagEntity.setAbbreviation(tagDto.getAbbreviation());

        return tagMapper.convertEntityToDto(tagEntity);
    }

    @Override
    public TagDto updateTag(Long tagId, TagDto tagDto) {

        if (tagId == null) {
            throw new IllegalArgumentException("TagId can't be null!");
        }

        if (tagDto == null) {
            throw new IllegalArgumentException("TagDto can't be null!");
        }

        Optional<Tag> existingTag = tagRepository.findById(tagId);

        if (existingTag.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "tag", tagId));
        }

        Tag tag = existingTag.get();

        tag.setName(tagDto.getName());
        tag.setAbbreviation(tagDto.getAbbreviation());

        return tagMapper.convertEntityToDto(tag);
    }

    @Override
    public TagDto deleteTag(Long tagId) {

        Optional<Tag> optionalTag = tagRepository.findById(tagId);

        if (optionalTag.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "tag", tagId));
        }

        Tag existingTag = optionalTag.get();
        return tagMapper.convertEntityToDto(existingTag);
    }
}
