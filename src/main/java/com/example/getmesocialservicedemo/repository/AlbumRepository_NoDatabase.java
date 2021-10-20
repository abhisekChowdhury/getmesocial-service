//package com.example.getmesocialservicedemo.repository;
//
//import com.example.getmesocialservicedemo.model.Album;
//import org.springframework.stereotype.Repository;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Repository
//public class AlbumRepository {
//    List<Album> albumList = new ArrayList();
//    //Album album = new Album(123, "Backend boys", "Test album", "album.com");
//
//    public List<Album> getAllAlbums() {
//        return albumList;
//    }
//
//    public Album getAlbumById(int albumId) {
//        for(Album album:albumList){
//            if(album.getAlbumId()==albumId){
//                return album;
//            }
//        }return null;
//    }
//
//    public Album saveAlbum(Album album) {
//        albumList.add(album);
//        return album;
//    }
//
//    public Album updateAlbum(int albumId, Album album) {
//        for (Album album1: albumList){
//            if (album1.getAlbumId()==albumId){
//                album1.setName(album.getName());
//                album1.setDescription(album.getDescription());
//                album1.setCoverPicUrl(album.getCoverPicUrl());
//                return album1;
//            }
//        }
//        return null;
//    }
//
//    public Album deleteAlbum(int albumId) {
//        Album deletedAlbum = null;
//        for (Album album1: albumList){
//            if (album1.getAlbumId()==albumId){
//                deletedAlbum = album1;
//                albumList.remove(deletedAlbum);
//                return deletedAlbum;
//            }
//        }
//        return deletedAlbum;
//    }
//}
