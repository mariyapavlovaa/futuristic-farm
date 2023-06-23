package com.uni.fmi.futuristicfarm.mapper.comment;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.comment.Comment;
import com.uni.fmi.futuristicfarm.rest.dto.comment.CommentDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

    CommentMapper MAPPER = Mappers.getMapper(CommentMapper.class);

    @Mapping(target = "article", ignore = true)
    @Mapping(source = "authorUsername", target = "commentWriter.username")
    @Mapping(target = "deleted", ignore = true)
    Comment convertDtoToEntity(CommentDto commentDto);

    @Mapping(source = "commentWriter.username", target = "authorUsername")
    @Mapping(source = "article.id", target = "articleId")
    @Mapping(source = "article.topicName", target = "articleTopicName")
    CommentDto convertEntityToDto(Comment comment);
}
