package com.uni.fmi.futuristicfarm.rest.dto.symptom;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;

public class SymptomDto extends BaseDto {

    @NotBlank
    private String name;

    public SymptomDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
