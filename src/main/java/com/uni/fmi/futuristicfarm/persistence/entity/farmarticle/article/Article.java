package com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article;

import com.sun.istack.NotNull;
import com.uni.fmi.futuristicfarm.persistence.entity.BaseEntity;
import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import java.time.LocalDate;

import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_COLUMN_POSTED_AT;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_DESCRIPTION;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_DESCRIPTION_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TABLE_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TOPIC_NAME;
import static com.uni.fmi.futuristicfarm.util.Constants.ARTICLE_TOPIC_NAME_SIZE;
import static com.uni.fmi.futuristicfarm.util.Constants.IS_DELETED;

@Entity
@Table(name = ARTICLE_TABLE_NAME)
public class Article extends BaseEntity {

    @NotNull
    @Size(max = ARTICLE_TOPIC_NAME_SIZE)
    @Column(name = ARTICLE_TOPIC_NAME)
    private String topicName;

    @NotNull
    @Size(max = ARTICLE_DESCRIPTION_SIZE)
    @Column(name = ARTICLE_DESCRIPTION)
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;

    @ManyToOne
    @JoinColumn(name = "season_phase_id")
    private SeasonPhase seasonPhase;

    @Column(name = ARTICLE_COLUMN_POSTED_AT)
    private LocalDate postedAt;

//    @Column(name = ARTICLE_COLUMN_TAG)
//    @ManyToMany
//    @JoinTable(
//            name = "article_tag",
//            joinColumns = @JoinColumn(name = "article_id"),
//            inverseJoinColumns = @JoinColumn(name = "tag_id"))
//    private Set<Tag> tagSet;

    @Column(name = IS_DELETED, columnDefinition = "boolean default false")
    private Boolean isDeleted;

    public Article() {
    }

    //TODO equals and hash code

    public Article(String topicName,
                   String description,
                   User author,
                   SeasonPhase seasonPhase,
                   LocalDate postedAt,
                   Boolean isDeleted) {

        this.topicName = topicName;
        this.description = description;
        this.author = author;
        this.seasonPhase = seasonPhase;
        this.postedAt = postedAt;
        this.isDeleted = isDeleted;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public SeasonPhase getSeasonPhase() {
        return seasonPhase;
    }

    public void setSeasonPhase(SeasonPhase seasonPhase) {
        this.seasonPhase = seasonPhase;
    }

    public LocalDate getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDate postedAt) {
        this.postedAt = postedAt;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

}