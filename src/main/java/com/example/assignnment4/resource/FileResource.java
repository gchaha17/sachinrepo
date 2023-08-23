
package com.example.assignnment4.resource;
import com.amazonaws.services.s3.Headers;

import com.amazonaws.services.s3.model.S3Object;

import com.example.assignnment4.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.core.io.ByteArrayResource;
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
    private FileService f1;
    @PostMapping
    public boolean upload(@RequestParam(name="file") MultipartFile file)
    {
        return f1.upload(file);

    }

    @GetMapping("/view")
    public void viewFile(@RequestParam(name="key")String key, HttpServletResponse response) throws IOException {

        S3Object object= f1.getFile(key);
        response.setContentType(object.getObjectMetadata().getContentType());
        response.getOutputStream().write(object.getObjectContent().readAllBytes());
    }
    @GetMapping("/download")
    public ResponseEntity<ByteArrayResource> download(@RequestParam(name="key")String key) throws IOException {
        S3Object object= f1.getFile(key);
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(object.getObjectMetadata().getContentType()))

                .header(Headers.CONTENT_DISPOSITION,"attachment;filename=\"" + key + "\"")
                .body(new ByteArrayResource(object.getObjectContent().readAllBytes()));


    }
    @DeleteMapping
    public void deleteFile(@RequestParam(name="key")String key)
    {
        f1.deleteFile(key);
    }

}