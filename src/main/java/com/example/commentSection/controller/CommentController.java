package com.example.commentSection.controller;


import com.example.commentSection.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import com.example.commentSection.service.CommentService;

import java.util.List;

@RestController
@RequestMapping ("/comments")
@CrossOrigin(origins = "https://commentsection-frontend-1.onrender.com")

public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<String> saveComment(@RequestBody Comment comment) {
        try {
            commentService.saveComment(comment);
            return ResponseEntity.ok("Comment added successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error adding comment: " + e.getMessage());
        }
    }


    @GetMapping
    public List<Comment> getComments() {
        return commentService.getAll();
    }
}
