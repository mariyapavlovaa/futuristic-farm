package com.uni.fmi.futuristicfarm.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public abstract class BaseDto implements Serializable {

//    @JsonIgnore
    private Long id;

    public BaseDto() {
    }

    public BaseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
