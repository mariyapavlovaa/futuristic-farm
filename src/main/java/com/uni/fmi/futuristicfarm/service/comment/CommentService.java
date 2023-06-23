package com.uni.fmi.futuristicfarm.service.comment;

import com.uni.fmi.futuristicfarm.rest.dto.comment.CommentDto;

import java.util.List;

public interface CommentService {

    List<CommentDto> findComments(Long commentId);

    CommentDto createComment(CommentDto commentDto);

    CommentDto updateComment(Long commentId, CommentDto commentDto);

    CommentDto deleteComment(Long commentId);

}
