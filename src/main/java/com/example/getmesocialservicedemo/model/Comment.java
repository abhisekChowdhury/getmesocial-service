package com.example.getmesocialservicedemo.model;

import com.example.getmesocialservicedemo.validation.ValidLowerAndNumber;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;

public class Comment {
    @Id
    private String commentId;
    private String photoId;
    @Length(min = 5)
    private String message;
    @NotEmpty @ValidLowerAndNumber
    private String createdBy;
    private String dateCreated;

    public Comment(String id, String photoId, String message, String createdBy, String dateCreated) {
        this.commentId = id;
        this.photoId = photoId;
        this.message = message;
        this.createdBy = createdBy;
        this.dateCreated = dateCreated;
    }

    public String getId() {
        return commentId;
    }

    public void setId(String id) {
        this.commentId = id;
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
