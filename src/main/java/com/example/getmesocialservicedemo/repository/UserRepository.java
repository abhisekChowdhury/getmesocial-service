package com.example.getmesocialservicedemo.repository;

import com.example.getmesocialservicedemo.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    //List<User> findAllByAddress(String address);


    List<User> findAllByAddress(String address);

    //format should be "findAllBy<fieldNameInEntityClass>"
    List<User> findAllByName(String name);

    //For single user:
    //Optional<User> findByName(String name);
}
