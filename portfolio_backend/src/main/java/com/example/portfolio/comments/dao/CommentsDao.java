package com.example.portfolio.comments.dao;

import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.comments.domain.Comments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsDao extends JpaRepository<Comments , Long> {

    @Query("SELECT o from Comments o WHERE o.isActive = true AND o.blog = :blog")
    List<Comments> findCommentsByBlog(Blogs blog);
}
