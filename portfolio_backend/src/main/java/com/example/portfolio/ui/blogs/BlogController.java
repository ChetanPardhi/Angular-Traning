package com.example.portfolio.ui.blogs;

import com.example.portfolio.blogs.domain.Blogs;
import com.example.portfolio.blogs.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin("**")
public class BlogController {

    @Autowired
    private BlogsService blogsService;

    @PostMapping("/blogs/create")
    public ResponseEntity<?> createBlog(@RequestBody Blogs blog , @RequestParam Long userId){
        return this.blogsService.createBlog(blog , userId);
    }

    @PutMapping("/blogs/edit/{blogId}")
    public ResponseEntity<?> updateBlog(@RequestBody Blogs blog , @RequestParam Long userId , @PathVariable Long blogId){
        return this.blogsService.updateBlog(userId, blogId, blog);
    }

    @GetMapping("/blogs/list")
    public ResponseEntity<?> getAllBlogs(){
        return this.blogsService.getAllBlogs();
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> getBlogsByParticularUser(@RequestParam Long userId){
        return this.blogsService.getAllBlogsOfParticularUser(userId);
    }
}
