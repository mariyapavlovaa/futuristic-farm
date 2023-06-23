package com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.comment;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static com.uni.fmi.futuristicfarm.util.Constants.COMMENT_CREATE_DATE;
import static com.uni.fmi.futuristicfarm.util.Constants.COMMENT_DATE_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.COMMENT_DESCRIPTION;
import static com.uni.fmi.futuristicfarm.util.Constants.COMMENT_DESCRIPTION_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.COMMENT_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;

@Entity
@Table(name = COMMENT_TABLE_NAME)
public class Comment extends BaseEntity {

    @NotNull
    @Size(max = COMMENT_DESCRIPTION_SIZE)
    @Column(name = COMMENT_DESCRIPTION)
    private String description;

    @ManyToOne
    @JoinColumn(name = "comment_writer_id")
    private User commentWriter;

    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;

    @Size(max = COMMENT_DATE_SIZE)
    @Column(name = COMMENT_CREATE_DATE)
    private LocalDate commentCreateDate;

    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    //TODO equals and hash
    public Comment() {
    }

    public Comment(String description,
                   User commentWriter,
                   Article article,
                   LocalDate commentCreateDate) {

        this.description = description;
        this.commentWriter = commentWriter;
        this.article = article;
        this.commentCreateDate = commentCreateDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getCommentWriter() {
        return commentWriter;
    }

    public void setCommentWriter(User commentWriter) {
        this.commentWriter = commentWriter;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LocalDate getCommentCreateDate() {
        return commentCreateDate;
    }

    public void setCommentCreateDate(LocalDate commentCreateDate) {
        this.commentCreateDate = commentCreateDate;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }
}
