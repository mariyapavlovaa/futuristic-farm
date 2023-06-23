package com.uni.fmi.futuristicfarm.service.comment;

import com.uni.fmi.futuristicfarm.mapper.article.ArticleMapper;
import com.uni.fmi.futuristicfarm.mapper.article.ArticleMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.comment.CommentMapper;
import com.uni.fmi.futuristicfarm.mapper.comment.CommentMapperImpl;
import com.uni.fmi.futuristicfarm.mapper.user.UserMapper;
import com.uni.fmi.futuristicfarm.mapper.user.UserMapperImpl;
import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.comment.Comment;
import com.uni.fmi.futuristicfarm.persistence.repository.comment.CommentRepository;
import com.uni.fmi.futuristicfarm.rest.dto.article.ArticleDto;
import com.uni.fmi.futuristicfarm.rest.dto.comment.CommentDto;
import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.service.article.ArticleService;
import com.uni.fmi.futuristicfarm.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    private final UserService userService;
    private final UserMapper userMapper;
    private final ArticleService articleService;
    private final ArticleMapper articleMapper;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              UserService userService,
                              ArticleService articleService) {

        this.commentRepository = commentRepository;
        this.userService = userService;
        this.articleService = articleService;
        this.commentMapper = new CommentMapperImpl();
        this.userMapper = new UserMapperImpl();
        this.articleMapper = new ArticleMapperImpl();
    }

    @Override
    public List<CommentDto> findComments(Long articleId) {
        if (articleId != null) {
            List<Comment> allByArticleId = commentRepository.findAllByArticleId(articleId);

            return allByArticleId.stream()
                    .map(commentMapper::convertEntityToDto)
                    .collect(Collectors.toList());
        }

        List<Comment> comments = commentRepository.findAll();
        return comments.stream()
                .map(commentMapper::convertEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CommentDto createComment(CommentDto commentDto) {

        if (commentDto == null) {
            throw new IllegalArgumentException("CommentDto can't be null!");
        }

        Comment commentEntity = commentMapper.convertDtoToEntity(commentDto);
        commentEntity.setDescription(commentDto.getDescription());

        UserDto user = userService.findUserByUsername(commentDto.getAuthorUsername());
        commentEntity.setCommentWriter(userMapper.convertDtoToEntity(user));

        ArticleDto articleDto = articleService.findArticleByArticleId(commentDto.getArticleId());
        commentEntity.setArticle(articleMapper.convertDtoToEntity(articleDto));

        commentEntity.setCommentCreateDate(commentDto.getCommentCreateDate());

        Comment comment = commentRepository.saveAndFlush(commentEntity);

        return commentMapper.convertEntityToDto(comment);

    }

    @Override
    public CommentDto updateComment(Long commentId, CommentDto commentDto) {

        if (commentId == null) {
            throw new IllegalArgumentException("Id can't be null!");
        }

        if (commentDto == null) {
            throw new IllegalArgumentException("CommentDto can't be null!");
        }

        Optional<Comment> existingComment = commentRepository.findById(commentId);

        if (existingComment.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "comment", commentDto.getId()));
        }

        Comment comment = existingComment.get();

        comment.setDescription(commentDto.getDescription());

        UserDto user = userService.findUserByUsername(commentDto.getAuthorUsername());
        comment.setCommentWriter(userMapper.convertDtoToEntity(user));

        ArticleDto articleDto = articleService.findArticleByArticleId(commentDto.getArticleId());
        comment.setArticle(articleMapper.convertDtoToEntity(articleDto));

        comment.setCommentCreateDate(commentDto.getCommentCreateDate());

        Comment commentResult = commentRepository.saveAndFlush(comment);

        return commentMapper.convertEntityToDto(commentResult);
    }

    @Override
    public CommentDto deleteComment(Long commentId) {

        Optional<Comment> optionalComment = commentRepository.findById(commentId);

        if (optionalComment.isEmpty()) {
            throw new IllegalArgumentException(String.format(
                    "There is no such record of %s with id = %d.", "comment", commentId));
        }

        Comment existingComment = optionalComment.get();

        existingComment.setDeleted(true);

        Comment comment = commentRepository.saveAndFlush(existingComment);

        return commentMapper.convertEntityToDto(comment);
    }

}
