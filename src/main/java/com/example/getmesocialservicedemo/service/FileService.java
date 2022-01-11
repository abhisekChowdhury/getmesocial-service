package com.example.getmesocialservicedemo.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {

    /**
     * Uploading a file
     * @param file
     * @return
     */
    public boolean upload(MultipartFile file) {

        /*
        * It is important select the right region as that of the bucket.
        * */
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(file.getSize());
            metadata.setContentType(file.getContentType());
            s3.putObject("backend-spring2021", file.getOriginalFilename(),file.getInputStream(),metadata);
            return true;
        } catch (AmazonServiceException | IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Viewing a file
     * @param key
     * @return
     */
    public S3Object viewFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        return s3.getObject("backend-spring2021",key);
    }

    /**
     * Deleting a file
     * @param key
     */
    public void deleteFile(String key) {
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIARV3O4DWZHNMZRPON", "b+xgLZJN77wzYtDlJUKgNuY5HfFZrOzY8QqSXg/G");
        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.US_WEST_2).build();
        s3.deleteObject("backend-spring2021",key);
    }
}

