package com.uni.fmi.futuristicfarm.rest.controller.comment;

import com.uni.fmi.futuristicfarm.rest.dto.comment.CommentDto;
import com.uni.fmi.futuristicfarm.rest.dto.user.UserDto;
import com.uni.fmi.futuristicfarm.service.comment.CommentService;
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
@Validated
@RequestMapping(Constants.API_V1 + Constants.COMMENT)
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CommentDto> findComments(@RequestParam(required = false) Long articleId) {
        return commentService.findComments(articleId);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto createComment(@Valid @RequestBody CommentDto commentDto) {
        return commentService.createComment(commentDto);
    }

    @PutMapping(value = "/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto updateComment(@PathVariable Long commentId,
                                    @Valid @RequestBody CommentDto commentDto) {
        return commentService.updateComment(commentId, commentDto);
    }

    @DeleteMapping(value = "/{commentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CommentDto deleteComment(@PathVariable Long commentId) {
        return commentService.deleteComment(commentId);
    }

}
