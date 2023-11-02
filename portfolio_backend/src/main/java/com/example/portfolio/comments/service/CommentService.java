package com.example.portfolio.comments.service;

import com.example.portfolio.comments.domain.Comments;
import org.springframework.http.ResponseEntity;

public interface CommentService {

    ResponseEntity<?> commentOnBlog(Long blogId , long userId, Comments comments);

    ResponseEntity<?> updateComment(Long blogId , long userId, Long commentId, Comments comments);

    ResponseEntity<?> getCommentsOfParticularBlog(Long blogId , long userId);

    ResponseEntity<?> deleteComment(Long blogId , long userId, Long commentId);
}
