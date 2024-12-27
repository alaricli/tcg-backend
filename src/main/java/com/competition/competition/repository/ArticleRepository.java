package com.competition.competition.repository;

import com.competition.competition.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    Article findBySlug(String slug);
}
