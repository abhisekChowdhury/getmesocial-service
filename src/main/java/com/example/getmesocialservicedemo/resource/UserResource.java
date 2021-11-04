package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.exception.RestrictedInfoException;
import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//THIS IS THE CONTROLLER CLASS
@RestController
@RequestMapping("/api/users")
public class UserResource {

    @Autowired
    private UserService userService;

    //When we want to post some data
    @PostMapping
    public User saveUser(@RequestBody @Valid User user){
        return userService.saveUser(user);
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
    public User updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam(name="userId") String userId){
        userService.deleteUser(userId);
    }

    @GetMapping("/name")
    public List<User> getByUserName(@RequestParam(name="name") String name) throws RestrictedInfoException{
        if (name.equalsIgnoreCase("root")){
            throw new RestrictedInfoException();
        }
        return userService.getByUserName(name);
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
