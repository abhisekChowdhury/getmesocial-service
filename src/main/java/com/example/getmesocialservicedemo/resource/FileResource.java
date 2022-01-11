package com.example.getmesocialservicedemo.resource;

import com.amazonaws.services.s3.Headers;
import com.amazonaws.services.s3.model.S3Object;
import com.example.getmesocialservicedemo.model.FirebaseUser;
import com.example.getmesocialservicedemo.service.FileService;
import com.example.getmesocialservicedemo.service.FirebaseService;
import com.google.firebase.auth.FirebaseAuthException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/files")
public class FileResource {

    @Autowired
    private FileService fileService;

    @Autowired
    private FirebaseService firebaseService;

    @PostMapping
    public boolean upload(@RequestParam(name = "file")MultipartFile file, @RequestHeader(name = "idToken") String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            return fileService.upload(file);
        }
        return false;
    }

    @GetMapping("/view")
    public void view(@RequestParam(name = "key") String key, HttpServletResponse response) throws IOException {
        S3Object object = fileService.viewFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download(@RequestParam(name = "key")String key, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            S3Object object = fileService.viewFile(key);
            return ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))
                    .header(Headers.CONTENT_DISPOSITION, "attachment; filename=\"" + key + "\"")
                    .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));
        }
        return null;
    }

    @DeleteMapping
    public void delete(@RequestParam(name="key")String key, @RequestHeader(name = "idToken")String idToken) throws IOException, FirebaseAuthException {
        FirebaseUser firebaseUser = firebaseService.authenticate(idToken);
        if (firebaseUser!=null) {
            fileService.deleteFile(key);
        }
    }
}
