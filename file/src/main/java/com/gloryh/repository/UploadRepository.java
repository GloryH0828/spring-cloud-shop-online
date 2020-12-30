package com.gloryh.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传接口
 *
 * @author 黄光辉
 * @since 2020/11/8
 **/
@Repository
public interface UploadRepository {
    /**
     * 图片上传
     * @param img 图片
     * @param id 对应的商品 id 或者 会员id
     * @param type 判断类型
     * @return 上传结果
0     */
    public int upload(MultipartFile img,String  id,int type);
}
