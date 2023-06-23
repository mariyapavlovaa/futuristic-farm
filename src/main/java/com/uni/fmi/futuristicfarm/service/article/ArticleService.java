package com.uni.fmi.futuristicfarm.service.article;

import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;

import java.util.List;

public interface ArticleService {

    List<ArticleDto> returnArticlesBySeasonPhase(String phaseName);

    List<ArticleDto> findAllArticles();

    ArticleDto findArticleByArticleId(Long articleId);

    /**
     * Creates and returns new Article.
     *
     * @param articleDto article {@link ArticleDto} dto which represents the object that will be persisted.
     * @return article
     */
    ArticleDto createArticle(ArticleDto articleDto);

    ArticleDto updateArticle(Long articleId, ArticleDto articleDto);

    ArticleDto deleteArticle(Long articleId);

}
