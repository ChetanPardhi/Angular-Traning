package com.example.portfolio.ui.comments;

import com.example.portfolio.comments.domain.Comments;
import com.example.portfolio.comments.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("**")
public class CommentsController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/blogs/{blogId}/postComments")
    public ResponseEntity<?> postCommentsOnBlog(
            @PathVariable Long blogId ,
            @RequestParam Long userId ,
            @RequestBody Comments comments){

        return  this.commentService.commentOnBlog(blogId , userId , comments);
    }

    @PutMapping("/blogs/{blogId}/comments/edit")
    public ResponseEntity<?> updateCommentsOnBlog(
            @PathVariable Long blogId ,
            @RequestParam Long userId ,
            @RequestParam Long commentId,
            @RequestBody Comments comments){

        return  this.commentService.updateComment(blogId , userId ,commentId , comments);
    }

    @GetMapping("/blogs/{blogId}/comments/list")
    public ResponseEntity<?> getCommentsOfParticularBlog(
            @PathVariable Long blogId ,
            @RequestParam Long userId
    ){
        return  this.commentService.getCommentsOfParticularBlog(blogId , userId);
    }

    @DeleteMapping("/blogs/{blogId}/comments/list")
    public ResponseEntity<?> deleteComment(
            @PathVariable Long blogId ,
            @RequestParam Long userId ,
            @RequestParam Long commentId
    ){
        return  this.commentService.deleteComment(blogId , userId , commentId);
    }
}
