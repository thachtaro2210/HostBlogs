package com.thachtaro.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.thachtaro.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findBySlugOrderByCreatedAtDesc(String slug);
}

