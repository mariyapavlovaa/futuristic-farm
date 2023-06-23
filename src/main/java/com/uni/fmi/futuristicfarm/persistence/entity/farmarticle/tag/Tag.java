package com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.tag;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TAG_ABBREVIATION;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TAG_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TAG_SIZE_ABBREVIATION;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TAG_SIZE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TAG_TABLE_NAME;

@Entity
@Table(name = ARTICLE_TAG_TABLE_NAME)
public class Tag extends BaseEntity {

    @NotNull
    @Size(max = ARTICLE_TAG_SIZE_NAME)
    @Column(name = ARTICLE_TAG_NAME)
    private String name;

    @NotNull
    @Size(max = ARTICLE_TAG_SIZE_ABBREVIATION)
    @Column(name = ARTICLE_TAG_ABBREVIATION)
    private String abbreviation;

    public Tag() {
    }

    //TODO equals and hash code
    public Tag(String name, String abbreviation) {
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
