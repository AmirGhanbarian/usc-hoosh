package com.example.hoosh.controller;


import com.example.hoosh.model.Attachment;
import com.example.hoosh.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attachments")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    // Upload attachment
    @PostMapping
    public Attachment uploadAttachment(@RequestBody Attachment attachment) {
        return attachmentService.saveAttachment(attachment);
    }

    // Get attachments by article ID
    @GetMapping("/article/{articleId}")
    public ResponseEntity<List<Attachment>> getAttachmentsByArticleId(@PathVariable String articleId) {
        List<Attachment> attachments = attachmentService.getAttachmentsByArticleId(articleId);
        return ResponseEntity.ok(attachments);
    }
}
