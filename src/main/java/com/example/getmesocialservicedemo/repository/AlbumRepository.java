package com.example.getmesocialservicedemo.repository;

import com.example.getmesocialservicedemo.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlbumRepository extends MongoRepository<Album,String> {
    Album findAllByAlbumId(String albumId);
}
