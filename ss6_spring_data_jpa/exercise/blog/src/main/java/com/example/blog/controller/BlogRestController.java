//package com.example.blog.controller;
//
//import com.example.blog.model.Blog;
//import com.example.blog.service.IBlogService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/blogs")
//public class BlogRestController {
//    @Autowired
//    private IBlogService blogService;
//
//    @GetMapping
//    public ResponseEntity<List<Blog>> getAllBlogs(@RequestParam(required = false) String search,
//                                                  @RequestParam(name = "page", defaultValue = "0") int page) {
//        int pageSize = 3;
//        PageRequest pageRequest = PageRequest.of(page, pageSize, Sort.by("date").ascending());
//
//        Page<Blog> blogPage;
//        if (search != null && !search.trim().isEmpty()) {
//            blogPage = blogService.searchByTitlePaged(search, pageRequest);
//        } else {
//            blogPage = blogService.findAllPaged(pageRequest);
//        }
//
//        List<Blog> blogList = blogPage.getContent();
//        return ResponseEntity.ok(blogList);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Blog> getBlogById(@PathVariable("id") int id) {
//        Blog blog = blogService.findById(id);
//        if (blog != null) {
//            return ResponseEntity.ok(blog);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @PostMapping
//    public ResponseEntity<Blog> createBlog(@RequestBody Blog blog) {
//        blogService.create(blog);
//        return ResponseEntity.ok(blog);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Blog> updateBlog(@PathVariable("id") int id, @RequestBody Blog updatedBlog) {
//        Blog blog = blogService.findById(id);
//        if (blog != null) {
//            // Update the existing blog with the new information
//            blog.setTitle(updatedBlog.getTitle());
//            blog.setContent(updatedBlog.getContent());
//            blog.setDate(updatedBlog.getDate());
//            // Set other properties as needed
//            blogService.edit(blog);
//            return ResponseEntity.ok(blog);
//        }
//        return ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteBlog(@PathVariable("id") int id) {
//        Blog blog = blogService.findById(id);
//        if (blog != null) {
//            blogService.deleteById(id);
//            return ResponseEntity.noContent().build();
//        }
//        return ResponseEntity.notFound().build();
//    }
//}
