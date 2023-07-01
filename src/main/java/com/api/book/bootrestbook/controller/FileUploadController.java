package com.api.book.bootrestbook.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.book.bootrestbook.helper.FileUploadHelper;

@RestController
public class FileUploadController {

    private FileUploadController fileUploadController;

    @PostMapping("/upload-file")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
        // System.out.println(file.getOriginalFilename());
        // System.out.println(file.getSize());
        // System.out.println(file.getContentType());
        try{
        if(file.isEmpty()){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Request must contain file");
        }

        //
       // if(file.getContentType().equals("image/jpeg"))
          // if(!file.getContentType().equals("image/jpeg"))
               if (!file.getContentType().equals("image/jpeg")){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Only jpeg contained allowed");
        }
    

        //file upload code
       boolean f=FileUploadHelper.uploadFile(file);
       if(f){
        //return ResponseEntity.ok("File uploaded sucessfully");
       // return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFileName().toUrlString()));
     return ResponseEntity.ok(ServletUriComponentsBuilder.fromCurrentContextPath().path("/image/").path(file.getOriginalFilename()).toUriString());
    }
    }
    catch(Exception e){
        e.printStackTrace();
    }
       // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong please try later......");
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("something went wrong please try later");
    }

    }

