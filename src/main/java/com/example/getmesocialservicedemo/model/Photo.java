package com.example.getmesocialservicedemo.model;

import com.example.getmesocialservicedemo.validation.ValidLowerAndNumber;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

public class Photo {

    @Id
    private String photoId;
    private String albumId;
    private String photoUrl;
    @NotEmpty @ValidLowerAndNumber
    private String createdBy;
    private String dateCreated;

    public Photo(String albumId, String photoUrl, String createdBy, String dateCreated) {
        this.albumId = albumId;
        this.photoUrl = photoUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }
}
