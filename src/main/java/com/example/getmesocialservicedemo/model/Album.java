package com.example.getmesocialservicedemo.model;

import com.example.getmesocialservicedemo.validation.ValidLowerAndNumber;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

public class Album {

    @Id
    String albumId;
    @Length(max = 10)
    String name;
    String coverPicUrl;
    @NotEmpty @ValidLowerAndNumber
    String createdBy;
    String dateCreated;

    public Album(String albumId, String name, String coverPicUrl, String createdBy, String dateCreated) {
        this.albumId = albumId;
        this.name = name;
        this.coverPicUrl = coverPicUrl;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverPicUrl() {
        return coverPicUrl;
    }

    public void setCoverPicUrl(String coverPicUrl) {
        this.coverPicUrl = coverPicUrl;
    }
}
