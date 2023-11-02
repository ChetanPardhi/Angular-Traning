package com.example.portfolio.comments.service;

import com.example.portfolio.blogs.dao.BlogsDao;
import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.comments.dao.CommentsDao;
import com.example.portfolio.comments.domain.Comments;
import com.example.portfolio.user.dao.UserDao;
import com.example.portfolio.user.domain.User;
import com.example.portfolio.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommentsServiceImpl implements CommentService{

    @Autowired
    private UserDao userDao;

    @Autowired
    private BlogsDao blogsDao;

    @Autowired
    private CommentsDao commentsDao;

    @Override
    public ResponseEntity<?> commentOnBlog(Long blogId, long userId, Comments comments) {

        Map<String,Object> response = new HashMap<>();
        Comments newComment = new Comments();

        try{
            User user = this.userDao.findById(userId).get();
            Blogs blog = this.blogsDao.findById(blogId).orElse(null);

            if (blog == null){
                response.put("message","No blog Exists");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            newComment.setBlog(blog);
            newComment.setCommentText(comments.getCommentText());
            newComment.setUser(user);

            newComment.setCommentType(
                    String.valueOf(
                            comments.getCommentType() == Utils.COMMENT_TYPE_REPLY ?
                                    Utils.COMMENT_TYPE_REPLY : Utils.COMMENT_TYPE_NEW_COMMENT
                    )
            );

            this.commentsDao.save(newComment);

            response.put("message","Commented Successfully");

            }
        catch (Exception e){
            e.printStackTrace();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateComment(Long blogId, long userId, Long commentId, Comments comments) {
        Map<String,Object> response = new HashMap<>();
        Comments existingComment = new Comments();

        try{
            existingComment = this.commentsDao.findById(commentId).get();

            User user = this.userDao.findById(userId).get();
            Blogs blog = this.blogsDao.findById(blogId).orElse(null);

            if(existingComment.getUser() != user){
                response.put("message","This is not your comment");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            existingComment.setCommentText(comments.getCommentText());

            this.commentsDao.save(existingComment);

            response.put("message","Comment updated Successfully");
            }
        catch (Exception e){
            e.printStackTrace();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getCommentsOfParticularBlog(Long blogId, long userId) {
        Map<String,Object> response = new HashMap<>();

        try{
//            User user = this.userDao.findById(userId).get();
            Blogs blog = this.blogsDao.findById(blogId).get();

            if (blog == null){
                response.put("message","No blog Exists");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }
            List<Comments> commentsList = this.commentsDao.findCommentsByBlog(blog);

            response.put("message","All Comments Fetched");
            response.put("comments",commentsList);
            }
        catch (Exception e){
            e.printStackTrace();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteComment(Long blogId, long userId, Long commentId) {
        Map<String,Object> response = new HashMap<>();

        try{
            User user = this.userDao.findById(userId).orElseThrow(null);

            Comments comments = this.commentsDao.findById(commentId).orElse(null);



            if (comments == null){

                response.put("message","No comment Exists");
                return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            }

            if (comments.getUser() == user){
                comments.setActive(false);
                this.commentsDao.save(comments);
            }

            response.put("message","Comments DELETED");
            }
        catch (Exception e){
            e.printStackTrace();
            response.put("message",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
