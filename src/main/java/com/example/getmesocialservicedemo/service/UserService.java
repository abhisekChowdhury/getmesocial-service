package com.example.getmesocialservicedemo.service;

import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        //return userRepository.saveUser(user);
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(String userId) {
        userRepository.deleteById(userId);
    }

    public List<User> getByAddress(String address) {
        return userRepository.findAllByAddress(address);
    }

//    public User getUser(){
//
//        //First we would call User Repository
//        return userRepository.findById();
//    }
//
//    public User saveUser(User user) {
//        return userRepository.saveUser(user);
//    }
//
//    public User getUserById(int userId) {
//        return userRepository.getUserId(userId);
//    }
//
//    public User updateUser(int userId, User user) {
//        return userRepository.updateUser(userId, user);
//    }
//
//    public User deleteUser(int userId) {
//        return userRepository.deleteUser(userId);
//    }
}
