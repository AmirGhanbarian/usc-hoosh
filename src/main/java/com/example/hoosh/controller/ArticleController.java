package com.example.hoosh.controller;

import com.example.hoosh.model.Article;
import com.example.hoosh.repository.ArticleRepository;
import com.example.hoosh.repository.AttachmentRepository;
import com.example.hoosh.service.ArticleService;
import com.example.hoosh.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/article")
public class ArticleController {


    ArticleRepository articleRepository;
    ArticleService articleService;


    AttachmentRepository attachmentRepository;
    AttachmentService attachmentService;


    @Autowired
    public ArticleController(ArticleRepository articleRepository,
                             ArticleService articleService,
                             AttachmentService attachmentService,
                             AttachmentRepository attachmentRepository) {
        this.articleRepository = articleRepository;
        this.articleService = articleService;
        this.attachmentRepository = attachmentRepository;
        this.attachmentService = attachmentService;
    }

    @GetMapping
    public ResponseEntity<HashMap<String, Object>> getAll() {

        HashMap<String, Object> output = new HashMap<>();
        output.put("articles", articleRepository.findAll());
        return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));

    }

    @PostMapping("/save")
    public ResponseEntity<HashMap<String, Object>> save(@RequestBody Article articleWithAttachmentsDTO) {
        HashMap<String, Object> output = new HashMap<>();
        try {
            Article savedArticle = articleService.save(articleWithAttachmentsDTO);
            output.put("saved_article", savedArticle);
            return new ResponseEntity<>(output, HttpStatusCode.valueOf(200));
        } catch (RuntimeException e) {
            output.put("errorMessage", "Title already exists");
            return new ResponseEntity<>(output, HttpStatusCode.valueOf(500));
        }
    }

    @PutMapping
    public ResponseEntity<HashMap<String, Object>> update(@RequestBody Article articleDetails, @RequestParam String id) {
        Article updatedArticle = articleService.updateArticle(id, articleDetails);
        HashMap<String, Object> output = new HashMap<>();
        output.put("updated_article", updatedArticle);
        return updatedArticle != null ? ResponseEntity.ok(output) : ResponseEntity.notFound().build();
    }


    @GetMapping("/paginated")
    public ResponseEntity<Page<Article>> getArticlesWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Article> articlePage = articleService.getArticlesWithPagination(pageable);
        return ResponseEntity.ok(articlePage);
    }


}
