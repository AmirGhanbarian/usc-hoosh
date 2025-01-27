package com.example.hoosh.service;

import com.example.hoosh.model.Article;
import com.example.hoosh.model.dto.ArticleWithAttachmentsDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface ArticleService {
    Article create(Article article);

    Article getById(String id);

    List<Article> getAllArticles();

    Article updateArticle(String id, Article article);

    void deleteArticle(String id);

    Page<Article> getArticlesWithPagination(Pageable pageable);

    Article saveArticleWithAttachments(ArticleWithAttachmentsDTO articleDTO);

    Article save(Article article);
}
