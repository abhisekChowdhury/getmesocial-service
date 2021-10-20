package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Comment;
import com.example.getmesocialservicedemo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @GetMapping
    public List<Comment> findAllComments(){
        return commentService.findAllComments();
    }

    @GetMapping("/id")
    public Comment findCommentById(@RequestParam(name = "commentId")String id){
        return commentService.findCommentById(id);
    }

    @PostMapping
    public Comment saveComment(Comment comment){
        return commentService.saveComment(comment);
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment){
        return commentService.updateComment(comment);
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name = "commentId") String id){
        commentService.deleteComment(id);
    }
}
