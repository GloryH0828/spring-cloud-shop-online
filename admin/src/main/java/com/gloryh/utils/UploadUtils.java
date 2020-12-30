package com.gloryh.utils;

import com.gloryh.feign.FileFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

/**
 * TODO
 *
 * @author 黄光辉
 * @since 2020/11/16
 **/
@Repository
public class UploadUtils extends HttpServlet {
    @Autowired
    private FileFeign fileFeign;
    private static FileSystemView fsv = FileSystemView.getFileSystemView();
    private static File home=fsv.getHomeDirectory();
    private static String homePath = home.getPath();
    private static String picturesPath = homePath+"\\pictures";
    private static String imagesPath=picturesPath+"\\images";
    public String upload(HttpServletRequest request, HttpServletResponse response) {
        String dir=picturesPath+"\\images";
        String filename = "";
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getSession().getServletContext());
        if(multipartResolver.isMultipart(request)){
            MultipartHttpServletRequest multipartHttpServletRequest= (MultipartHttpServletRequest) request;
            Iterator<String> iterator=multipartHttpServletRequest.getFileNames();
            System.out.println("iter.hasNext():"+iterator.hasNext());
            while (iterator.hasNext()){
                MultipartFile multipartFile=multipartHttpServletRequest.getFile(iterator.next());
                String name = multipartFile.getOriginalFilename();
                System.out.println("upload name:"+name);
                if (name==null||name.trim().equals("")){
                    continue;
                }
                Integer index=name.lastIndexOf("\\");
                String newString="";
                if(index>-1){
                    newString=name.substring(index+1);
                }else {
                    newString=name;
                }
                if(!newString.equals("")){
                    filename=newString;
                }
                System.out.println("new fileName:"+filename);
                if (multipartFile!=null){
                    System.out.println("not null");
                    filename = UUID.randomUUID().toString().replace("-", "") + filename;
                    fileFeign.upload(multipartFile,filename,3);
                }
            }
        }
        return filename;
    }
    public void fileBrowse(HttpServletRequest request, HttpServletResponse response)
            throws ServletException,  IOException {
        File root = new File(imagesPath);
        String path = request.getContextPath() + "/";
        String clientPath="images/";
        if(!root.exists()){
            root.mkdirs();
        }
        String callback = request.getParameter("CKEditorFuncNum");
        File[] files = root.listFiles();
        if(files.length > 0){

            for(File file:files ) {
                String src = path + clientPath + file.getName();
                response.getWriter().print("<img width='110px' height='70px' src='" +src + "' alt='" + file.getName() + "' onclick=\"funCallback("+callback+",'"+ src +"')\">");
            }
        }else{
            response.getWriter().print("<h3>未检测到资源。</h3>");
        }
        String script ="<script type='text/javascript'>"+
                "function funCallback(funcNum,fileUrl){"+
                "var parentWindow = ( window.parent == window ) ? window.opener : window.parent;"+
                "parentWindow.CKEDITOR.tools.callFunction(funcNum, fileUrl);"+
                "window.close();}"+"</script>";
        response.getWriter().print(script);
    }
}
