package com.example.portfolio.blogs.service;

import com.example.portfolio.blogs.dao.BlogsDao;
import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.user.dao.UserDao;
import com.example.portfolio.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Service
public class BlogServiceImpl implements BlogsService{

    @Autowired
    private BlogsDao blogsDao;

    @Autowired
    private UserDao userDao;

    @Override
    public ResponseEntity<?> createBlog(Blogs blog , Long userId) {

        HashMap<String , String> response = new HashMap<>();
        Blogs newBlog = new Blogs();

        try{

            User user = this.userDao.findById(userId).get();

            newBlog.setBlogTitle(blog.getBlogTitle());
            newBlog.setAuthor(blog.getAuthor());
            newBlog.setContent(blog.getContent());
            newBlog.setPublishDate(new Date());
            newBlog.setAuthor(user);
            newBlog.setActive(true);

            newBlog.setCodingLanguage(blog.getCodingLanguage());

            this.blogsDao.save(newBlog);

            response.put("message","Blogs created successfully");

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> updateBlog(Long userId, Long blogId, Blogs blog) {

        HashMap<String , String> response = new HashMap<>();

        try{
            User user = this.userDao.findById(userId).get();
            Blogs existingBlog = this.blogsDao.findByBlogIdAndAuthor(blogId , user);

            existingBlog.setBlogTitle(blog.getBlogTitle() == null ? existingBlog.getBlogTitle() : blog.getBlogTitle() );
            existingBlog.setContent(blog.getContent() == null ? existingBlog.getContent() : blog.getContent());

            this.blogsDao.save(existingBlog);

            response.put("message","Blog updated successfully");

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getBlogById(Long userId,Long blogId) {

        HashMap<String , Object> response = new HashMap<>();

        try{
            User user = this.userDao.findById(userId).get();
            Blogs blog = this.blogsDao.findByBlogIdAndAuthor(blogId , user);

            response.put("message","Blog found successfully");
            response.put("blog" , blog);

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBlogsOfParticularUser(Long userId) {

        HashMap<String , Object> response = new HashMap<>();

        try{

            User user = this.userDao.findById(userId).get();
            List<Blogs> blogsList = this.blogsDao.findByAuthor(user);

            response.put("message","Blogs found successfully");
            response.put("blogs" , blogsList);

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getAllBlogs() {

        HashMap<String , Object> response = new HashMap<>();

        try{
            List<Blogs> blogsList = this.blogsDao.findAll();

            response.put("message","Blogs founded successfully");
            response.put("blogs" , blogsList);

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> deleteBlog(Long userId,Long blogId) {

        HashMap<String , String> response = new HashMap<>();

        try{
            User user = this.userDao.findById(userId).get();
            Blogs blog = this.blogsDao.findByBlogIdAndAuthor(blogId , user);

            blog.setActive(false);

            response.put("message","Blog Deleted successfully");

        }catch (Exception e){
            response.put("message" , e.getMessage());
            return new ResponseEntity<>(response , HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
