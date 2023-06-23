package com.uni.fmi.futuristicfarm.persistence.repository.comment;

import com.uni.fmi.futuristicfarm.persistence.entity.farmarticle.comment.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByArticleId(Long articleId);
}
