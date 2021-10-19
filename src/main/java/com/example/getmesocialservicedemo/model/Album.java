package com.example.getmesocialservicedemo.model;

public class Album {
    int albumId;
    String name;
    String description;
    String coverPicUrl;

    public Album(int albumId, String name, String description, String coverPicUrl) {
        this.albumId = albumId;
        this.name = name;
        this.description = description;
        this.coverPicUrl = coverPicUrl;
    }

    public int getAlbumId() {
        return albumId;
    }

    public void setAlbumId(int albumId) {
        this.albumId = albumId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }
}
