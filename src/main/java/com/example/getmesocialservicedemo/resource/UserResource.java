package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.exception.RestrictedInfoException;
import com.example.getmesocialservicedemo.model.FirebaseUser;
import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.service.FirebaseService;
import com.example.getmesocialservicedemo.service.UserService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

//THIS IS THE CONTROLLER CLASS
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @Autowired
    private FirebaseService firebaseService;

    //When we want to post some data
    @PostMapping
    public User saveUser(@RequestBody @Valid User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser != null){
            return userService.saveUser(user);
        }else{
            return null;
        }
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/address")
    public List<User> getByAddress(@RequestParam(name = "address") String address) throws RestrictedInfoException {
        if(address.equalsIgnoreCase("area51")){
            throw new RestrictedInfoException();
        }
        return userService.getByAddress(address);
    }

    @GetMapping("/find-by-id")
    public User getById(@RequestParam("userId")String userId){
        return userService.getById(userId);
    }

    @PutMapping
    public User updateUser(@RequestBody User user, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return userService.updateUser(user);
        }
        return null;
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            userService.deleteUser(userId);
        }
    }

    @GetMapping("/name")
    public List<User> getByUserName(@RequestParam(name="name") String name, @RequestHeader(name = "idToken")String idToken) throws RestrictedInfoException, IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            if (name.equalsIgnoreCase("root")) {
                throw new RestrictedInfoException();
            }
            return userService.getByUserName(name);
        }
        return null;
    }

    //For Single User
//    @GetMapping("/userName")
//    public Optional<User> getByUserName(@RequestParam(name = "name") String name){
//        return userService.getByUserName(name);
//    }

//    @GetMapping
//    public User getUser() {
//        //First we would call user service and then user repository
//        return userService.getUser();
//    }
//
//    @GetMapping("/user/{userId}")
//    public User getUserById(@PathVariable("userId") int userId){
//        return userService.getUserById(userId);
//    }
//
//    @PutMapping("/user/{userId}")
//    public User updateUser(@PathVariable("userId") int userId, @RequestBody User user){
//        return userService.updateUser(userId, user);
//    }
//
//    @DeleteMapping("/user")
//    public User deleteUser(@RequestParam(name="userId") int userId){
//        return userService.deleteUser(userId);
//    }
}
