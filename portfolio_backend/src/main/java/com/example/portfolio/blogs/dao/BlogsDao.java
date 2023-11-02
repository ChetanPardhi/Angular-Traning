package com.example.portfolio.blogs.dao;

import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogsDao extends JpaRepository<Blogs , Long> {

    @Query("SELECT o FROM Blogs o WHERE o.isActive = true AND o.blogId = :blogId AND o.author = :author")
    Blogs findByBlogIdAndAuthor(Long blogId , User author);

    @Query("SELECT o from Blogs o WHERE o.isActive = true AND o.author = :author")
    List<Blogs> findByAuthor(User author);

    @Override
    @Query("SELECT o from Blogs o WHERE o.isActive = true")
    List<Blogs> findAll();
}
