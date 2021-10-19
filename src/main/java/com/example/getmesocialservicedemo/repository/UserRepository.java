package com.example.getmesocialservicedemo.repository;

import com.example.getmesocialservicedemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    //List<User> findAllByAddress(String address);


    List<User> findAllByAddress(String address);
}
