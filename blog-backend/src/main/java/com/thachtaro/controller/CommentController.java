package com.thachtaro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thachtaro.model.Comment;
import com.thachtaro.repository.CommentRepository;
import java.time.LocalDateTime;
@RestController
@RequestMapping("/api/comments")
public class CommentController {

    @Autowired
    private CommentRepository repo;

    @PostMapping("/{slug}")
    public ResponseEntity<?> addComment(@PathVariable String slug, @RequestBody Comment comment) {
        comment.setSlug(slug);
        comment.setCreatedAt(LocalDateTime.now());
        return ResponseEntity.ok(repo.save(comment));
    }

    @GetMapping("/{slug}")
    public List<Comment> getComments(@PathVariable String slug) {
        return repo.findBySlugOrderByCreatedAtDesc(slug);
    }
}

