package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserResource {
    @GetMapping("/user")
    public User getUser() {
        User user = new User("Abhisek", "Canada", 27, "picture.com");
        return user;
    }
}
