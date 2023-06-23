package com.uni.fmi.futuristicfarm.rest.dto.comment;

import com.uni.fmi.futuristicfarm.rest.dto.BaseDto;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

public class CommentDto extends BaseDto {

    @NotBlank
    private String authorUsername;

    @NotBlank
    private String description;

    private LocalDate commentCreateDate;

    private Long articleId;

    private String articleTopicName;


    public CommentDto() {
    }

    public CommentDto(String authorUsername,
                      String description,
                      LocalDate commentCreateDate,
                      Long articleId,
                      String articleTopicName) {

        this.authorUsername = authorUsername;
        this.description = description;
        this.commentCreateDate = commentCreateDate;
        this.articleId = articleId;
        this.articleTopicName = articleTopicName;

    }

    public String getAuthorUsername() {
        return authorUsername;
    }

    public void setAuthorUsername(String authorUsername) {
        this.authorUsername = authorUsername;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(LocalDate commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public String getArticleTopicName() {
        return articleTopicName;
    }

    public void setArticleTopicName(String articleTopicName) {
        this.articleTopicName = articleTopicName;
    }

}
