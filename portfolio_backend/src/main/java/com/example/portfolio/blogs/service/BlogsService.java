package com.example.portfolio.blogs.service;

import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.user.domain.User;
import org.springframework.http.ResponseEntity;

public interface BlogsService {

    ResponseEntity<?> createBlog(Blogs blog , Long userId);

    ResponseEntity<?> updateBlog(Long userId , Long blogId ,Blogs blog);

    ResponseEntity<?> getBlogById(Long userId,Long blogId);

    ResponseEntity<?> getAllBlogsOfParticularUser(Long userId);

    ResponseEntity<?> getAllBlogs();

    ResponseEntity<?> deleteBlog(Long userId, Long blogId);
}
