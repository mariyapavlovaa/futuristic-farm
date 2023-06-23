package com.uni.fmi.futuristicfarm.mapper.article;

import com.uni.fmi.futuristicfarm.mapper.tag.TagMapper;
import com.uni.fmi.futuristicfarm.mapper.tag.TagMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.article.Article;
import com.uni.fmi.futuristicfarm.persistence.entity.seasonphase.SeasonPhase;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.user.User;
import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ArticleMapper {

    ArticleMapper MAPPER = Mappers.getMapper(ArticleMapper.class);
    TagMapper tagMapper = new TagMapperImpl();

    default Article convertDtoToEntity(ArticleDto articleDto) {

        Article article = new Article();
        article.setId(articleDto.getId());
        article.setTopicName(articleDto.getTopicName());
        article.setDescription(articleDto.getDescription());

        User author = new User();
        author.setFirstName(articleDto.getAuthorFirstName());
        author.setLastName(articleDto.getAuthorLastName());
        author.setUsername(articleDto.getAuthorUsername());
        article.setAuthor(author);

        article.setSeasonPhase(new SeasonPhase(articleDto.getSeasonPhaseName()));
        article.setPostedAt(articleDto.getPostedAt());

//        Set<Tag> tagSet = articleDto.getTagSet()
//                .stream()
//                .map(tagMapper::convertDtoToEntity)
//                .collect(Collectors.toSet());
//
//        article.setTagSet(tagSet);

        return article;
    }

    default ArticleDto convertEntityToDto(Article article) {

        ArticleDto articleDto = new ArticleDto();
        articleDto.setId(article.getId());
        articleDto.setTopicName(article.getTopicName());
        articleDto.setDescription(article.getDescription());
        articleDto.setAuthorFirstName(article.getAuthor().getFirstName());
        articleDto.setAuthorLastName(article.getAuthor().getLastName());
        articleDto.setAuthorUsername(article.getAuthor().getUsername());
        articleDto.setSeasonPhaseName(article.getSeasonPhase().getPhaseName());
        articleDto.setPostedAt(article.getPostedAt());

        return articleDto;
    }
}

//    @Mapping(source = "authorFirstName", target = "author.firstName")
//    @Mapping(source = "authorLastName", target = "author.lastName")
//    @Mapping(source = "authorUsername", target = "author.username")
//    @Mapping(source = "seasonPhaseName", target = "seasonPhase.phaseName")
//    Article convertDtoToEntity(ArticleDto articleDto);
//
//    ArticleDto convertEntityToDto(Article article);