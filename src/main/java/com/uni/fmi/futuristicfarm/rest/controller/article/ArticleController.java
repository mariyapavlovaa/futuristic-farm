package com.uni.fmi.futuristicfarm.rest.controller.article;

import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;
import com.uni.fmi.futuristicfarm.service.article.ArticleService;
import com.uni.fmi.futuristicfarm.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(Constants.API_V1 + Constants.ARTICLE)
@Validated
public class ArticleController {

    private final ArticleService articleService;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> findAllArticles() {

        return articleService.findAllArticles();
    }

    @GetMapping(value = "/season/phase/name", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleDto> returnArticlesBySeasonPhase(@RequestParam(required = false) String phaseName) {

        return articleService.returnArticlesBySeasonPhase(phaseName);
    }

    @GetMapping(value = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto findArticleById(@PathVariable Long articleId) {
        return articleService.findArticleByArticleId(articleId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto createArticle(@Valid @RequestBody ArticleDto articleDto) {

        return articleService.createArticle(articleDto);
    }

    @PutMapping(value = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto updateArticle(@PathVariable Long articleId,
                                    @Valid @RequestBody ArticleDto articleDto) {
        return articleService.updateArticle(articleId, articleDto);
    }

    @DeleteMapping(value = "/{articleId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleDto deleteArticle(@PathVariable Long articleId) {
        return articleService.deleteArticle(articleId);
    }

}
