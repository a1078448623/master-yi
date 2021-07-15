package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:ImageServiceImpl
 *@author:wsn
 *date:2021/7/14 11:02
 */

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wuyan.masteryi.mall.mapper.UserMapper;
import com.wuyan.masteryi.mall.utils.FileUtil;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService{

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String,Object> saveImage(MultipartFile file,int u_id) {


        String ACCESS_KEY = "tD9IOSLKC_xU1XOWYZO7VZRI1ksRdzqDaYkXnOEd";
        String SECRET_KEY = "V9DDOECx7aG5tTmqqfEYlqdrqk6UWL-wdBlmOcQa";

        String bucketname = "maseryi";


        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

        Configuration cfg = new Configuration(Zone.zone1());

        UploadManager uploadManager = new UploadManager(cfg);

        String QINIU_IMAGE_DOMAIN = "http://qw7r9ly4i.hb-bkt.clouddn.com/";

        String upToken = auth.uploadToken(bucketname);
        int dotPos = file.getOriginalFilename().lastIndexOf(".");
        if (dotPos < 0) {
            return ResponseMsg.sendMsg(100,"图片格式不正确",null);
        }
        String fileExt = file.getOriginalFilename().substring(dotPos + 1).toLowerCase();

        if (!FileUtil.isFileAllowed(fileExt)) {
            return ResponseMsg.sendMsg(100,"图片格式不正确",null);
        }
        String key = null;
        try {
            Response res = uploadManager.put(file.getBytes(), key, upToken);
            DefaultPutRet putRet = new Gson().fromJson(res.bodyString(), DefaultPutRet.class);
            String url=QINIU_IMAGE_DOMAIN+putRet.key;
            userMapper.chengImgUrl(url,u_id);
            return ResponseMsg.sendMsg(200,"上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseMsg.sendMsg(100,"上传失败",null);

        }

    }
}
