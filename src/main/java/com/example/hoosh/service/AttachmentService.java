package com.example.hoosh.service;

import com.example.hoosh.model.Attachment;

import java.util.List;

public interface AttachmentService {


    Attachment saveAttachment(Attachment attachment);

    List<Attachment> getAttachmentsByArticleId(String articleId);
}
