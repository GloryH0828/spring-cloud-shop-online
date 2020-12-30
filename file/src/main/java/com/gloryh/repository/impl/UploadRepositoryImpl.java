package com.gloryh.repository.impl;

import com.gloryh.repository.UploadRepository;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件上传实现类
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Repository
public class UploadRepositoryImpl implements UploadRepository {

    private static FileSystemView fsv = FileSystemView.getFileSystemView();
    private static File home=fsv.getHomeDirectory();
    private static String homePath = home.getPath();
    private static String picturesPath = homePath+"\\pictures";
    private static String headPath =picturesPath+"\\head";
    private static String productPath = picturesPath+"\\product";
    private static String imagesPath =picturesPath+"\\images";
    @Override
    public int upload(MultipartFile img, String id, int type) {
        if(img.getSize()>0){
            File file=new File("");
            switch (type){
                case 1:
                    file= new File(headPath+"\\"+id+".jpg");
                    if(file.exists()){
                        file.delete();
                    }
                     file= new File(headPath,id+".jpg");
                    break;
                case 2:
                    file= new File(productPath+"\\"+id+".jpg");
                    if(file.exists()){
                        file.delete();
                    }
                     file = new File(productPath,id+".jpg");
                    break;
                case 3:
                    file=new File(imagesPath,id);
            }
            if(file!=null){
                try {
                    img.transferTo(file);

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("文件上传失败！");
                    return 1;
                }
            }
        }
        return 0;
    }
}
