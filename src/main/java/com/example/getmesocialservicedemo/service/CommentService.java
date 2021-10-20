package com.example.getmesocialservicedemo.service;

import com.example.getmesocialservicedemo.model.Comment;
import com.example.getmesocialservicedemo.repository.AlbumRepository;
import com.example.getmesocialservicedemo.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public List<Comment> findAllComments() {
        return commentRepository.findAll();
    }

    public Comment findCommentById(String id) {
        return commentRepository.findAllByCommentId(id);
    }

    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    public void deleteComment(String id) {
        commentRepository.deleteById(id);
    }
}
