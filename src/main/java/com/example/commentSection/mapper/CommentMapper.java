package com.example.commentSection.mapper;

import com.example.commentSection.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setName(rs.getString("name"));
        comment.setText(rs.getString("text"));
        return comment;
    }
}
