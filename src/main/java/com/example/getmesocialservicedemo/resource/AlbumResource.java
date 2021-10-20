package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Album;
import com.example.getmesocialservicedemo.model.User;
import com.example.getmesocialservicedemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/album")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @PostMapping
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
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
    public Album updateAlbum(@RequestBody Album album){
        return albumService.updateAlbum(album);
    }

    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId")String albumId){
        albumService.deleteAlbum(albumId);
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
