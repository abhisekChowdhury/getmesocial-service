package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Comment;
import com.example.getmesocialservicedemo.model.FirebaseUser;
import com.example.getmesocialservicedemo.service.CommentService;
import com.example.getmesocialservicedemo.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/comment")
public class CommentResource {

    @Autowired
    CommentService commentService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Comment> findAllComments(){
        return commentService.findAllComments();
    }

    @GetMapping("/id")
    public Comment findCommentById(@RequestParam(name = "commentId")String id){
        return commentService.findCommentById(id);
    }

    @PostMapping
    public Comment saveComment(@Valid Comment comment, @RequestHeader(name="idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return commentService.saveComment(comment);
        }
        return null;
    }

    @PutMapping
    public Comment updateComment(@RequestBody Comment comment, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return commentService.updateComment(comment);
        }
        return null;
    }

    @DeleteMapping
    public void deleteComment(@RequestParam(name = "commentId") String id, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            commentService.deleteComment(id);
        }
    }
}
