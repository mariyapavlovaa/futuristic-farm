package com.uni.fmi.futuristicfarm.rest.dto.tag;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

public class TagDto extends BaseDto {

    private String name;
    private String abbreviation;

    public TagDto() {
    }

    public TagDto(String name, String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }
}
