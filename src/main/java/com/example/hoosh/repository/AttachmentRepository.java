package com.example.hoosh.repository;

import com.example.hoosh.model.Attachment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AttachmentRepository extends MongoRepository<Attachment, String> {
    List<Attachment> findByArticleId(String articleId);
}
