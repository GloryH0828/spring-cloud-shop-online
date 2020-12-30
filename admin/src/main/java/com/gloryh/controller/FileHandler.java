package com.gloryh.controller;

import com.alibaba.fastjson.JSONObject;
import com.gloryh.feign.FileFeign;
import com.gloryh.feign.ProductFeign;
import com.gloryh.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 文件上传
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Controller
@RequestMapping("/file")
public class FileHandler extends HttpServlet {
    @Autowired
    private FileFeign fileFeign;
    @Autowired
    private UploadUtils uploadUtils;
    @Autowired
    private ProductFeign productFeign;
    @PostMapping("/upload/{id}/{type}")
    @ResponseBody
    public String upload(@RequestBody(required = false) MultipartFile photo, @PathVariable String id, @PathVariable int type) {
        int state = fileFeign.upload(photo, id, type);
        if (type ==2){
            productFeign.updatePhotoState(id,1);
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("status", state);
        return jsonObject.toJSONString();
    }

    @PostMapping("/upload/content")
    public void uploadContentFile(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String callback = request.getParameter("CKEditorFuncNum");
        String filepath = uploadUtils.upload(request, response);
        String script = "<script type='text/javascript'>window.parent.CKEDITOR.tools.callFunction(" + callback + ",'"+request.getContextPath() +"/images/"+filepath+"')</script>";
        response.getWriter().print(script);
    }
    @GetMapping("/fileBrowse")
    public void fileBrowse(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");//获取文件名时防止中文乱码
        response.setContentType("text/html;charset=utf-8");
        uploadUtils.fileBrowse(request,response);
    }

}