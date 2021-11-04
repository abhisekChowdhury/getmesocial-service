package com.example.getmesocialservicedemo.model;

import com.example.getmesocialservicedemo.validation.ValidName;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class User {


    @Id
    private String id;
    @NotEmpty(message = "User Name cannot be empty") @ValidName
    private String name;
    private String address;
    @Min(value = 18) @Max(value = 100)
    private int age;
    @Email
    @NotEmpty(message = "Email cannot be empty")
    private String email;
    @NotEmpty(message = "Profile picture URL cannot be empty")
    private String profilePicUrl;

    public User(String name, String address, int age, String email, String profilePicUrl) {
        this.name = name;
        this.address = address;
        this.age = age;
        this.email = email;
        this.profilePicUrl = profilePicUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getProfilePicUrl() {
        return profilePicUrl;
    }

    public void setProfilePicUrl(String profilePicUrl) {
        this.profilePicUrl = profilePicUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
