package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.FirebaseUser;
import com.example.getmesocialservicedemo.model.Photo;
import com.example.getmesocialservicedemo.service.FirebaseService;
import com.example.getmesocialservicedemo.service.PhotoService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/photo")
public class PhotoResource {

    @Autowired
    private PhotoService photoService;

    @Autowired
    private FirebaseService firebaseService;

    @GetMapping
    public List<Photo> getAllPhotos(){
        return photoService.getAllPhotos();
    }

    @GetMapping("/id")
    public Photo getPhotoById(@RequestParam(name = "photoId") String photoId){
        return photoService.getPhotoById(photoId);
    }

    @PutMapping
    public Photo updatePhoto(@RequestBody Photo photo, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return photoService.updatePhoto(photo);
        }
        return null;
    }

    @PostMapping
    public Photo savePhoto(@Valid Photo photo, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException{
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return photoService.savePhoto(photo);
        }
        return null;
    }

    @DeleteMapping
    public void deletePhoto(@RequestParam(name = "photoId") String photoId, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException{
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            photoService.deletePhoto(photoId);
        }
    }
}
