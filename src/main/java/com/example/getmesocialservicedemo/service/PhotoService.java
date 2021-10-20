package com.example.getmesocialservicedemo.service;

import com.example.getmesocialservicedemo.model.Photo;
import com.example.getmesocialservicedemo.repository.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhotoService {

    @Autowired
    private PhotoRepository photoRepository;


    public List<Photo> getAllPhotos() {
        return photoRepository.findAll();
    }

    public Photo getPhotoById(String photoId) {
        return photoRepository.findAllByPhotoId(photoId);
    }

    public Photo updatePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public Photo savePhoto(Photo photo) {
        return photoRepository.save(photo);
    }

    public void deletePhoto(String photoId) {
        photoRepository.deleteById(photoId);
    }
}
