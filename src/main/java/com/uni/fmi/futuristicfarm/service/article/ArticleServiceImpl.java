package com.uni.fmi.futuristicfarm.service.article;

import com.uni.fmi.futuristicfarm.mapper.article.ArticleMapper;
import com.uni.fmi.futuristicfarm.mapper.article.ArticleMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapper;
import com.uni.fmi.futuristicfarm.mapper.seasonphase.SeasonPhaseMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.tag.TagMapper;
import com.uni.fmi.futuristicfarm.mapper.tag.TagMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.user.UserMapper;
import com.uni.fmi.futuristicfarm.mapper.user.UserMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;
import com.uni.fmi.futuristicfarm.persistence.repository.article.ArticleRepository;
import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;
import com.uni.fmi.futuristicfarm.rest.dto.seasonphase.SeasonPhaseDto;
import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.service.seasonphase.SeasonPhaseService;
import com.uni.fmi.futuristicfarm.service.tag.TagService;
import com.uni.fmi.futuristicfarm.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final UserServiceImpl userService;
    private final UserMapper userMapper;
    private final SeasonPhaseService seasonPhaseService;
    private final SeasonPhaseMapper seasonPhaseMapper;
    private final TagService tagService;
    private final TagMapper tagMapper;

    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository,
                              UserServiceImpl userService,
                              SeasonPhaseService seasonPhaseService, TagService tagService) {

        this.articleRepository = articleRepository;
        this.userService = userService;
        this.seasonPhaseService = seasonPhaseService;
        this.tagService = tagService;
        articleMapper = new ArticleMapperImpl();
        userMapper = new UserMapperImpl();
        seasonPhaseMapper = new SeasonPhaseMapperImpl();
        this.tagMapper = new TagMapperImpl();
    }

    @Override
    public List<ArticleDto> returnArticlesBySeasonPhase(String phaseName) {
        List<Article> articles;

        if (phaseName != null) {
            articles = articleRepository.findAllBySeasonPhasePhaseName(phaseName);
        } else {
            articles = articleRepository.findAll();
        }

        return articles.stream()
                .map(articleMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArticleDto> findAllArticles() {

        List<Article> articleList = articleRepository.findAll();

        return articleList.stream()
                .map(articleMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDto findArticleByArticleId(Long articleId) {

        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("Article not found with such id!"));

        return articleMapper.convertEntityToDto(article);
    }

    @Override
    public ArticleDto createArticle(ArticleDto articleDto) {

        if (articleDto == null) {
            throw new IllegalArgumentException("ArticleDto can't be null!");
        }
        UserDto userByUsername = userService.findUserByUsername(articleDto.getAuthorUsername());
        User user = userMapper.convertDtoToEntity(userByUsername);

        Article article = articleMapper.convertDtoToEntity(articleDto);
        article.setAuthor(user);

        SeasonPhaseDto phase = seasonPhaseService.findSeasonPhaseByPhaseName(articleDto.getSeasonPhaseName());
        SeasonPhase seasonPhase = seasonPhaseMapper.convertDtoToEntity(phase);
        article.setSeasonPhase(seasonPhase);

//        Set<TagDto> tagSet = articleDto.getTagSet();
//        Set<Tag> collect = tagSet.stream().map(tagMapper::convertDtoToEntity).collect(Collectors.toSet());
//        article.setTagSet(collect);
        Article savedArticle = articleRepository.saveAndFlush(article);

        return articleMapper.convertEntityToDto(savedArticle);
    }

    @Override
    public ArticleDto updateArticle(Long articleId, ArticleDto articleDto) {

        if (articleId == null) {
            throw new IllegalArgumentException("Id can't be null!");
        }

        if (articleDto == null) {
            throw new IllegalArgumentException("ArticleDto can't be null!");
        }

        Optional<Article> existingArticle = articleRepository.findById(articleId);

        if (existingArticle.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "article", articleId));
        }

        Article article = existingArticle.get();

        article.setTopicName(articleDto.getTopicName());
        article.setDescription(articleDto.getDescription());

        UserDto userByUsername = userService.findUserByUsername(articleDto.getAuthorUsername());
        article.setAuthor(userMapper.convertDtoToEntity(userByUsername));

        SeasonPhaseDto seasonByName = seasonPhaseService.findSeasonPhaseByPhaseName(articleDto.getSeasonPhaseName());
        article.setSeasonPhase(seasonPhaseMapper.convertDtoToEntity(seasonByName));

        article.setPostedAt(articleDto.getPostedAt());

//        article.setTagSet(Set.of());
        //tag TODO to finish with tag

        Article savedArticle = articleRepository.saveAndFlush(article);
        return articleMapper.convertEntityToDto(savedArticle);

    }

    @Override
    public ArticleDto deleteArticle(Long articleId) {

        Optional<Article> optionalArticle = articleRepository.findById(articleId);

        if (optionalArticle.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "article", articleId));
        }

        Article existingArticle = optionalArticle.get();
        existingArticle.setIsDeleted(true);

        Article article = articleRepository.saveAndFlush(existingArticle);

        return articleMapper.convertEntityToDto(existingArticle);
    }

}
