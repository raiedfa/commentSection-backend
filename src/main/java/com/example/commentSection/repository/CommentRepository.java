package com.example.commentSection.repository;

import com.example.commentSection.mapper.CommentMapper;
import com.example.commentSection.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepository {
@Autowired
    private JdbcTemplate jdbcTemplate;

    public void saveComment(Comment comment) {
        String sql = "INSERT INTO comments (name, text) VALUES (?, ?)";
        try {
            jdbcTemplate.update(sql, comment.getName(), comment.getText());
            System.out.println("Comment added successfully!");
        } catch (Exception e) {
            System.out.println("Error while adding comment: " + e.getMessage());
        }
    }


public List<Comment> getAll(){
        try {
            String sql = "SELECT * FROM comments " ;
            List<Comment> comments = jdbcTemplate.query(sql , new CommentMapper());
            return comments;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
}


}
