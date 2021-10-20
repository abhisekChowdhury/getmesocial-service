package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Photo;
import com.example.getmesocialservicedemo.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/id")
    public Photo getPhotoById(@RequestParam(name = "photoId") String photoId){
        return photoService.getPhotoById(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo){
        return photoService.updatePhoto(photo);
    }

    @PostMapping
    public Photo savePhoto(Photo photo){
        return photoService.savePhoto(photo);
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photoId") String photoId){
        photoService.deletePhoto(photoId);
    }
}
