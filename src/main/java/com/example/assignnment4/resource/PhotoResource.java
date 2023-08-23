package com.example.assignnment4.resource;

import com.example.assignnment4.model.Photo;
import com.example.assignnment4.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/photo")
@CrossOrigin(origins = {"http://assi4and5.s3-website-us-west-2.amazonaws.com","http://localhost:4200","http://assi667766.s3-website-us-west-2.amazonaws.com","http://assi7.s3-website-us-west-2.amazonaws.com","http://realassi4bckt.s3-website-us-west-2.amazonaws.com","http://assi5realone.s3-website-us-west-2.amazonaws.com"})
public class PhotoResource {

    @Autowired
    private PhotoService prs;
    @PostMapping()
    public Photo savePhoto(@RequestBody @Valid  Photo p1)
    {
        return prs.savePhoto(p1);

    }
/*    @GetMapping("/photo/{Id}")
    public Optional<Photo> getPhotoById(@PathVariable(name="Id") String photoId, @RequestHeader(name="idToken")String idToken)
    {


        return  prs.getPhotoById(photoId);


    }  */


    @GetMapping()
    public List<Photo> getPhoto()
    {
        return prs.getPhoto();

    }
    @PutMapping()
    public Photo updatePhoto(@RequestBody Photo p1)
    {

        return prs.updatePhoto(p1);
    }
    @DeleteMapping()
    public void deletePhoto(@RequestParam(name="photoId")String photoId)
    {
        prs.deletePhoto(photoId);

    }
    @PutMapping("/update")
    public Photo updatePhoto1(@RequestParam(name="photoUrl") Photo photoUrl,@RequestBody Photo p1, @RequestHeader(name="idToken")String idToken)
    {

        return prs.updatePhoto(p1);
    }

    @GetMapping("/photo/{photoId}")
    public  List<Photo>getPhotoByAlbumId(@RequestParam(required=false,name = "id")String albumId)
    {

        return prs.getPhotoByAlbumId(albumId);
    }
    @GetMapping("/get/photo/{photoId}")
    public List<Photo> getPhotoById(@RequestParam(name="Id") String photoId, @RequestHeader(name="idToken")String idToken)
    {
        return  prs.getPhotoById(photoId);
    }

}