package com.example.getmesocialservicedemo.resource;

import com.example.getmesocialservicedemo.model.Album;
import com.example.getmesocialservicedemo.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AlbumResource {

    @Autowired
    private AlbumService albumService;

    @GetMapping("/album")
    public List<Album> getAllAlbums(){
        return albumService.getAllAlbums();
    }

    //Fix this
    @GetMapping("/album/{albumId}")
    public Album getAlbumById(@PathVariable("userId") int albumId){
        return albumService.getAlbumById(albumId);
    }

    @PostMapping("/album")
    public Album saveAlbum(@RequestBody Album album){
        return albumService.saveAlbum(album);
    }

    @PutMapping("/album/{albumId}")
    public Album updateAlbum(@PathVariable("albumId") int albumId, @RequestBody Album album){
        return albumService.updateAlbum(albumId, album);
    }

    @DeleteMapping("/user")
    public Album deleteAlbum(@RequestParam(name="albumId") int albumId){
        return albumService.deleteAlbum(albumId);
    }

}
