package com.uni.fmi.futuristicfarm.rest.dto.article;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class ArticleDto extends BaseDto {

    @NotBlank
    private String topicName;

    @NotBlank
    private String description;

    private String authorFirstName;

    private String authorLastName;

    private String authorUsername;

    @NotBlank
    private String seasonPhaseName;

    private LocalDate postedAt;

    //@JsonProperty("tags")
//    private Set<TagDto> tagSet;

    public ArticleDto() {
    }

    public ArticleDto(String topicName,
                      String description,
                      String authorFirstName,
                      String authorLastName,
                      String authorUsername,
                      String seasonPhaseName,
                      LocalDate postedAt) {

        this.topicName = topicName;
        this.description = description;
        this.authorFirstName = authorFirstName;
        this.authorLastName = authorLastName;
        this.authorUsername = authorUsername;
        this.seasonPhaseName = seasonPhaseName;
        this.postedAt = postedAt;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public String getAuthorLastName() {
        return authorLastName;
    }

    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getSeasonPhaseName() {
        return seasonPhaseName;
    }

    public void setSeasonPhaseName(String seasonPhaseName) {
        this.seasonPhaseName = seasonPhaseName;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

}
