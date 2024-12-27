package com.competition.competition.controller;

import com.competition.competition.dto.ArticleRequestDTO;
import com.competition.competition.dto.ArticleResponseDTO;
import com.competition.competition.dto.ArticleResponseSimplifiedDTO;
import com.competition.competition.entity.Article;
import com.competition.competition.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ArticleController {
    private final ArticleService articleService;

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @PostMapping("/add/articles")
    public ResponseEntity<List<Article>> addArticles(@RequestBody List<ArticleRequestDTO> articles) {
        List<Article> articlesCreated = articleService.createArticles(articles);
        return new ResponseEntity<>(articlesCreated, HttpStatus.OK);
    }

    @GetMapping("/get/articles")
    public ResponseEntity<List<ArticleResponseSimplifiedDTO>> getArticles() {
        List<ArticleResponseSimplifiedDTO> responses = articleService.findAll();
        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    @GetMapping("/get/article/{slug}")
    public ResponseEntity<ArticleResponseDTO> getArticle(@PathVariable("slug") String slug) {
        ArticleResponseDTO response = articleService.findBySlug(slug);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/get/article/id/{id}")
    public ResponseEntity<ArticleResponseDTO> getArticle(@PathVariable Long id) {
        ArticleResponseDTO response = articleService.findById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/article/id/{id}")
    public ResponseEntity<Boolean> deleteArticle(@PathVariable("id") Long id) {
        if (articleService.deleteById(id)) {
            return new ResponseEntity<>(articleService.deleteById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>(articleService.deleteById(id), HttpStatus.NOT_FOUND);
    }
}
