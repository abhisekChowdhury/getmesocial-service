package com.example.getmesocialservicedemo.model;

import org.springframework.data.annotation.Id;

public class User {


    @Id
    private String id;
    private String name;
    private String address;
    private int age;
    private String profilePicUrl;

    public User(String name, String address, int age, String profilePicUrl) {
        this.name = name;
        this.address = address;
        this.age = age;
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
}
