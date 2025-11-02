package com.example.commentSection.service;

import com.example.commentSection.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commentSection.repository.CommentRepository;

import java.util.List;

@Service
public class CommentService {


    @Autowired
    private CommentRepository commentRepository;

    public void saveComment(Comment comment) {
        commentRepository.saveComment(comment);
    }

    public List<Comment> getAll(){
        return commentRepository.getAll();
    }

}
