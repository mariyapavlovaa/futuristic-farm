package com.uni.fmi.futuristicfarm.persistence.repository.article;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

    List<Article> findAllBySeasonPhasePhaseName(String phaseName);
}
