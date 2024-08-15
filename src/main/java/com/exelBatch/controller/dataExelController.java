package com.exelBatch.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.exelBatch.service.dataExelService;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class dataExelController {

  @Autowired
  private dataExelService dService;

   @PostMapping("/upload")
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "Please select a file!";
        }

        try {
            // Menyimpan file ke direktori lokal
            String uploadDir = "D:/wrok/";
            File uploadDirFile = new File(uploadDir);
            if (!uploadDirFile.exists()) {
                uploadDirFile.mkdirs();
            }
            File dest = new File(uploadDir + file.getOriginalFilename());
            file.transferTo(dest);

            return dService.publishAPI(dest.getPath());
        } catch (IOException e) {
            return "Failed to upload file";
        }
    }
  
}
