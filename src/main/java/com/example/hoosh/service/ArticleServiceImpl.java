package com.example.hoosh.service;

import com.example.hoosh.model.Article;
import com.example.hoosh.model.Attachment;
import com.example.hoosh.model.dto.ArticleWithAttachmentsDTO;
import com.example.hoosh.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ArticleServiceImpl implements ArticleService{
    ArticleRepository articleRepository;
    AttachmentService attachmentService;
    @Autowired
    public ArticleServiceImpl(ArticleRepository articleRepository,
                              AttachmentService attachmentService) {
        this.articleRepository = articleRepository;
        this.attachmentService = attachmentService;

    }


    public List<Article> getUnSubmittedArticles(){
        return articleRepository.findByState(0);
    }



    @Override
    public Article create(Article article) {
        return articleRepository.save(article);
    }

    @Override
    public Article getById(String id) {
        return null;
    }

    @Override
    public List<Article> getAllArticles() {
        return null;
    }

    public Article updateArticle(String id, Article article) {
        if (!articleRepository.existsById(id)) {
            return null; // or throw an exception if preferred
        }
        article.setId(id);
        return articleRepository.save(article);
    }


    public Page<Article> getArticlesWithPagination(Pageable pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public void deleteArticle(String id) {

    }

    public Article saveArticleWithAttachments(ArticleWithAttachmentsDTO articleDTO) {
        Article article = new Article();
        article.setTitle(articleDTO.getTitle());
        article.setContent(articleDTO.getContent());
        article.setAuthor(articleDTO.getAuthor());

        // Save the article first to get its ID
        Article savedArticle = articleRepository.save(article);

        // Save attachments and link them to the article
        if (articleDTO.getAttachments() != null) {
            for (Attachment attachment : articleDTO.getAttachments()) {
                attachment.setArticleId(savedArticle.getId()); // Set the article ID
                attachmentService.saveAttachment(attachment);
            }
        }

        return savedArticle;
    }

}
