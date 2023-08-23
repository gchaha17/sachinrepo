package com.example.assignnment4.repoistery;

import com.example.assignnment4.model.Photo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhotoRepo extends MongoRepository<Photo,String> {

   // List<Photo> findAllByPhotoId(String photoId);



     List<Photo> findAllById(String photoId);

     List<Photo> findByAlbumId(String albumId);


     // List<Photo> findAllByPhotoId(String photoId);
}