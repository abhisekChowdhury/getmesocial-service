//package com.example.getmesocialservicedemo.repository;
//
//import com.example.getmesocialservicedemo.model.User;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class UserRepository {
//
//    List<User> userList = new ArrayList();
//
//    public User getUser(){
//        User user = new User("Abhisek", "Canada", 27, "picture.com");
//        return user;
//    }
//
//    public User saveUser(User user) {
//        user.setId(userList.size()+1);  //The user ID will be assigned as per the increase in size 1, 2, 3, 4...
//        userList.add(user);
//        return user;
//    }
//
//    public List<User> getAllUsers() {
//        return userList;
//    }
//
//    public User getUserId(int userId) {
//        for (User user: userList){
//            if (user.getId()==userId){
//                return user;
//            }
//        }
//        return null;
//    }
//
//    public User updateUser(int userId, User user) {
//        for (User user1: userList){
//            if (user1.getId()==userId){
//                user1.setName(user.getName());
//                user1.setAddress(user.getAddress());
//                user1.setAge(user.getAge());
//                user1.setProfilePicUrl(user.getProfilePicUrl());
//                return user1;
//            }
//        }
//        return null;
//    }
//
//    public User deleteUser(int userId) {
//        User deletedUser = null;
//        for (User user1: userList){
//            if (user1.getId()==userId){
//                deletedUser = user1;
//                userList.remove(deletedUser);
//                return deletedUser;
//            }
//        }
//        return deletedUser;
//    }
//}
