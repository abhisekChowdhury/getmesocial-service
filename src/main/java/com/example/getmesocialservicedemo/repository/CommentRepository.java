package com.example.getmesocialservicedemo.repository;

import com.example.getmesocialservicedemo.model.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String > {
    Comment findAllByCommentId(String id);
}
