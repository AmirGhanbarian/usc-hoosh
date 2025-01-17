package com.example.hoosh.service;


import com.example.hoosh.model.Attachment;
import com.example.hoosh.repository.AttachmentRepository;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;
import com.example.hoosh.model.Article;
import com.example.hoosh.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import java.util.List;

@Service
public class AttachmentServiceImpl implements AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;



    @Override
    public Attachment saveAttachment(Attachment attachment) {
        try {
            return attachmentRepository.save(attachment);
        } catch (DuplicateKeyException e) {
            // Handle the exception (e.g., log it, throw a custom exception, etc.)
            throw new RuntimeException("Attachment with the same file name already exists: " + attachment.getFileName());
        }
    }


    public List<Attachment> getAttachmentsByArticleId(String articleId) {
        return attachmentRepository.findByArticleId(articleId);
    }
}