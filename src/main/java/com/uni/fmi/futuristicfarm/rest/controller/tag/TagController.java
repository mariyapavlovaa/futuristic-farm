package com.uni.fmi.futuristicfarm.rest.controller.tag;

import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;
import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;
import com.uni.fmi.futuristicfarm.rest.dto.tag.TagDto;
import com.uni.fmi.futuristicfarm.service.article.ArticleService;
import com.uni.fmi.futuristicfarm.service.tag.TagService;
import com.uni.fmi.futuristicfarm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(Constants.API_V1 + Constants.TAG)
@Validated
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Set<TagDto> findAllTags() {

        return tagService.findTags();
    }

    @GetMapping(value = "/{tagId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto findTagById(@PathVariable Long tagId) {

        return tagService.findTagById(tagId);
    }
//TODO to check
    @GetMapping(path = "/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto findTagByName(@RequestParam String name) {

        return tagService.findTagByName(name);
    }
//TODO to check
    @GetMapping(path = "/abbreviation", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto findTagByAbbreviation(@RequestParam String abbreviation) {

        return tagService.findTagByAbbreviation(abbreviation);
    }
//TODO
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto createTag(@Valid @RequestBody TagDto tagDto) {

        return tagService.createTag(tagDto);
    }

    @PutMapping(value = "/{tagId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto updateTag(@PathVariable Long tagId,
                            @Valid @RequestBody TagDto tagDto) {

        return tagService.updateTag(tagId, tagDto);
    }

    @DeleteMapping(value = "/{tagId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TagDto deleteTag(@PathVariable Long tagId) {

        return tagService.deleteTag(tagId);
    }

}
