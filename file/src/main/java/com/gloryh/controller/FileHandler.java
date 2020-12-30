package com.gloryh.controller;

import com.gloryh.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import java.io.FileNotFoundException;

/**
 * 图片上传
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@RestController
@RequestMapping("/file")
public class FileHandler {
    @Autowired
    private UploadRepository uploadRepository;
    @PostMapping(value = "/upload/{id}/{type}")
    public int upload(@RequestPart("photo") MultipartFile multipartFile, @PathVariable String id, @PathVariable int type){
        return uploadRepository.upload(multipartFile,id,type);
    }

}
