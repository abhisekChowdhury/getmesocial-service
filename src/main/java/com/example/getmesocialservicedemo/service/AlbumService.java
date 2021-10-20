package com.example.getmesocialservicedemo.service;

import com.example.getmesocialservicedemo.model.Album;
import com.example.getmesocialservicedemo.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    public Album saveAlbum(Album album) {
        return albumRepository.save(album);
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album getByAlbumId(String albumId) {
        return albumRepository.findAllByAlbumId(albumId);
    }

    public Album updateAlbum(Album album) {
        return albumRepository.save(album);
    }

    public void deleteAlbum(String albumId) {
        albumRepository.deleteById(albumId);
    }

    //Needs work
//    public Optional<Album> getAlbumById(String albumId) {
//        return albumRepository.findById(albumId);
//    }

//    public Album saveAlbum(Album album) {
//        return albumRepository.saveAlbum(album);
//    }
//
//    public List<Album> getAllAlbums() {
//        return albumRepository.getAllAlbums();
//    }
//
//    public Album getAlbumById(int albumId) {
//        return albumRepository.getAlbumById(albumId);
//    }
//
//    public Album updateAlbum(int albumId, Album album) {
//        return albumRepository.updateAlbum(albumId,album);
//    }
//
//    public Album deleteAlbum(int albumId) {
//        return albumRepository.deleteAlbum(albumId);
//    }
}
