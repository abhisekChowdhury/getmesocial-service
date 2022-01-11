package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Album;
import com.example.getmesocialservicedemo.model.FirebaseUser;
import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.service.AlbumService;
import com.example.getmesocialservicedemo.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album album, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return albumService.saveAlbum(album);
        }
        return null;
    }

    @GetMapping
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    @GetMapping("/id")
    public Album getByAlbumId(@RequestParam(name = "albumId") String albumId){
        return albumService.getByAlbumId(albumId);
    }

    @PutMapping
    public Album updateAlbum(@RequestBody Album album, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return albumService.updateAlbum(album);
        }
        return null;
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId")String albumId, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            albumService.deleteAlbum(albumId);
        }
    }

    //Needs work
//    @GetMapping
//    public Optional<Album> getAlbumById(@PathVariable("albumId") String albumId){
//        return albumService.getAlbumById(albumId);
//    }

//
//    @GetMapping("/album")
//    public List<Album> getAllAlbums(){
//        return albumService.getAllAlbums();
//    }
//
//    //Fix this
//    @GetMapping("/album/{albumId}")
//    public Album getAlbumById(@PathVariable("albumId") int albumId){
//        return albumService.getAlbumById(albumId);
//    }
//
//    @PostMapping("/album")
//    public Album saveAlbum(@RequestBody Album album){
//        return albumService.saveAlbum(album);
//    }
//
//    @PutMapping("/album/{albumId}")
//    public Album updateAlbum(@PathVariable("albumId") int albumId, @RequestBody Album album){
//        return albumService.updateAlbum(albumId, album);
//    }
//
//    @DeleteMapping("/user")
//    public Album deleteAlbum(@RequestParam(name="albumId") int albumId){
//        return albumService.deleteAlbum(albumId);
//    }

}
