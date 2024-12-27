package com.competition.competition.service;

import com.competition.competition.dto.ArticleContentResponseDTO;
import com.competition.competition.dto.ArticleRequestDTO;
import com.competition.competition.dto.ArticleResponseDTO;
import com.competition.competition.dto.ArticleResponseSimplifiedDTO;
import com.competition.competition.entity.Article;
import com.competition.competition.entity.ArticleContent;
import com.competition.competition.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> createArticles(List<ArticleRequestDTO> requests) {
        List<Article> articles = new ArrayList<>();
        for (ArticleRequestDTO request : requests) {
            Article article = new Article();
            article.setTitle(request.getTitle());
            article.setTags(request.getTags());
            article.setCreated_at(request.getCreated_at());
            article.setUpdated_at(request.getUpdated_at());
            article.setSlug(request.getSlug());
            article.setAuthor(request.getAuthor());
            article.setImage(request.getImage());

            List<ArticleContent> contents = request.getContents().stream().map(articleContent -> {
                ArticleContent content = new ArticleContent();
                content.setContent(articleContent.getContent());
                content.setContentType(articleContent.getContentType());
                content.setPosition(articleContent.getPosition());
                content.setArticle(article);
                return content;
            }).toList();

            article.setContents(contents);
            articles.add(article);
        }

        return articleRepository.saveAll(articles);
    }

    public List<ArticleResponseSimplifiedDTO> findAll() {
        List<Article> articles = articleRepository.findAll();
        List<ArticleResponseSimplifiedDTO> response = new ArrayList<>();

        for (Article article : articles) {
            response.add(mapArticleToSimplifiedResponse(article));
        }

        return response;
    }

    public ArticleResponseDTO findBySlug(String slug) {
        Article article = articleRepository.findBySlug(slug);
        assert article != null;
        return mapArticleToResponse(article);
    }

    public ArticleResponseDTO findById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        assert article != null;
        return mapArticleToResponse(article);
    }

    public Boolean deleteById(Long id) {
        Article article = articleRepository.findById(id).orElse(null);
        if (article != null) {
            articleRepository.delete(article);
            return true;
        }
        return false;
    }

    // helpers
    private ArticleResponseDTO mapArticleToResponse(Article article) {
        ArticleResponseDTO response = new ArticleResponseDTO();
        response.setId(article.getId());
        response.setTitle(article.getTitle());
        response.setContents(mapContentsToResponses(article.getContents()));
        response.setCreated_at(article.getCreated_at());
        response.setUpdated_at(article.getUpdated_at());
        response.setSlug(article.getSlug());
        response.setAuthor(article.getAuthor());
        response.setImage(article.getImage());
        return response;
    }

    private ArticleResponseSimplifiedDTO mapArticleToSimplifiedResponse(Article article) {
        ArticleResponseSimplifiedDTO response = new ArticleResponseSimplifiedDTO();
        response.setId(article.getId());
        response.setTitle(article.getTitle());
        response.setCreated_at(article.getCreated_at());
        response.setUpdated_at(article.getUpdated_at());
        response.setSlug(article.getSlug());
        response.setAuthor(article.getAuthor());
        response.setImage(article.getImage());
        return response;
    }

    private List<ArticleContentResponseDTO> mapContentsToResponses(List<ArticleContent> contents) {
        List<ArticleContentResponseDTO> response = new ArrayList<>();
        for (ArticleContent content : contents) {
            ArticleContentResponseDTO responseDTO = new ArticleContentResponseDTO();
            responseDTO.setContentType(content.getContentType());
            responseDTO.setContent(content.getContent());
            responseDTO.setPosition(content.getPosition());
            response.add(responseDTO);
        }

        return response;
    }
}
