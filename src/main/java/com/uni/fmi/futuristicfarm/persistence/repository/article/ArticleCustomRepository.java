package com.uni.fmi.futuristicfarm.persistence.repository.article;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;

import java.util.List;

public interface ArticleCustomRepository {

  List<Article> returnArticlesBySeasonPhase(String phaseName);
}
