package com.uni.fmi.futuristicfarm.persistence.repository.article;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;

public class ArticleCustomRepositoryImpl extends QuerydslRepositorySupport implements ArticleCustomRepository {

    public ArticleCustomRepositoryImpl() {
        super(Article.class);
    }

    @Override
    public List<Article> returnArticlesBySeasonPhase(String phaseName) {


        return null;
    }
}
