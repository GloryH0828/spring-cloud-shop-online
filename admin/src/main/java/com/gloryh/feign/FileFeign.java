package com.gloryh.feign;

import com.gloryh.config.FileConfiguration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

/**
 * 文件上传
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Repository
@FeignClient(value = "file",configuration = FileConfiguration.class)
public interface FileFeign {
    /**
     * 图片上传
     * @param photo
     * @param id
     * @param type
     * @return
     */
    @PostMapping(value = "/file/upload/{id}/{type}",consumes = MediaType.MULTIPART_FORM_DATA)
    public int upload(@RequestPart("photo") MultipartFile photo, @PathVariable String id, @PathVariable int type);

}
