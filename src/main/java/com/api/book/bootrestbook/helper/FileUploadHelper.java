package com.api.book.bootrestbook.helper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;

import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileUploadHelper {
    //public static final String UPLOAD_DIR="C:\\Users\\Admin\\Documents\\JUNE_2023\\spring\\springboot\\bootrestbook\\src\\main\\resources\\static\\image";
    public static final String UPLOAD_DIR;

static{

    try{   UPLOAD_DIR = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    }catch(IOException e){
        throw new RuntimeException("failed to initialized upload directory");
    }
}
    
    public FileUploadHelper()throws IOException{

    }

   
    
    
    private InputStream inputStream;

    public static boolean uploadFile(MultipartFile multipartFile){
        boolean f=false;
try{
//     //
// InputStream is = multipartFile.getInputStream();
// byte data[]=new byte[is.available()];
// is.read(data);

// //
// FileOutputStream fos= new FileOutputStream(UPLOAD_DIR+"\\"+multipartFile.getOriginalFilename());
// fos.write(data);
// fos.close();
Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+multipartFile.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
//Files.copy(multipartFile.getInputStream(), Paths.get(UPLOAD_DIR+File.separator+, null)
// String fileName=multipartFile.getOriginalFilename();
// Path destination=Paths.get(UPLOAD_DIR,fileName);
// Files.copy(file.getInputStream,destination,StandardCopyOption.REPLACE_EXISTING);
//return ResponseEntity.ok("done");
f=true;

}catch(Exception e){e.printStackTrace();}

        return f;
    }
}
