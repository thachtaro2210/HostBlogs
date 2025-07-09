package com.thachtaro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thachtaro.model.View;
import com.thachtaro.repository.ViewRepository;

@RestController
@RequestMapping("/api/views")
public class ViewController {

    @Autowired
    private ViewRepository repo;

   @PostMapping("/{slug}")
public ResponseEntity<?> incrementView(@PathVariable String slug) {
    View view = repo.findById(slug).orElseGet(() -> {
        View v = new View();
        v.setSlug(slug);   
        v.setCount(0);     
        return v;
    });
    view.setCount(view.getCount() + 1);
    repo.save(view);
    return ResponseEntity.ok(view.getCount());
}


    @GetMapping("/{slug}")
    public ResponseEntity<?> getView(@PathVariable String slug) {
        return ResponseEntity.ok(
            repo.findById(slug).map(View::getCount).orElse(0)
        );
    }
}
