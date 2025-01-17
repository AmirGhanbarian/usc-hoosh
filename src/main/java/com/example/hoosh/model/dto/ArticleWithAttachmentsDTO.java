package com.example.hoosh.model.dto;

import com.example.hoosh.model.Attachment;

import java.util.List;

public class ArticleWithAttachmentsDTO {
    private String title;
    private String content;
    private String author;
    private List<Attachment> attachments;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments) {
        this.attachments = attachments;
    }
}
