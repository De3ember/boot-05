package com.zwy.boot05.controller;

import lombok.val;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String formLayOut(){
        return "form/form_layouts";
    }
    @PostMapping("/upload")
    public String upload(@RequestParam("email")String email,
                         @RequestParam("username")String username,
                         @RequestPart("headerImg")MultipartFile headImg,
                         @RequestPart("photos")MultipartFile[] photos) throws IOException {
        if(!headImg.isEmpty()){
            String originalFilename = headImg.getOriginalFilename();
            headImg.transferTo(new File("E:\\cache\\"+originalFilename));
        }
        if (photos.length>0){
            for (MultipartFile photo:photos ){
                if(!photo.isEmpty()){
                    String originalFilename = photo.getOriginalFilename();
                    photo.transferTo(new File("E:\\cache\\"+originalFilename));
                }
            }
        }

        return "index";
    }
}
