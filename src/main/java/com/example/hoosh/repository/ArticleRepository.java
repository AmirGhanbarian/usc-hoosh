package com.example.hoosh.repository;


import com.example.hoosh.model.Article;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends MongoRepository<Article, String> {
    Article findByTitle(String title);
    List<Article> findByState(int state);

}
