package com.example.getmesocialservicedemo.repository;

import com.example.getmesocialservicedemo.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PhotoRepository extends MongoRepository<Photo,String> {
    Photo findAllByPhotoId(String photoId);
}
