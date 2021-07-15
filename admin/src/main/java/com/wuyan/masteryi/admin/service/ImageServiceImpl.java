package com.wuyan.masteryi.admin.service;

import com.google.gson.Gson;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.wuyan.masteryi.admin.mapper.GoodsMapper;
import com.wuyan.masteryi.admin.utils.FileUtil;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

/*
 *project:master-yi
 *file:ImageServiceImpl
 *@author:wsn
 *date:2021/7/15 9:19
 */
@Service
public class ImageServiceImpl implements ImageService{
    String ACCESS_KEY = "tD9IOSLKC_xU1XOWYZO7VZRI1ksRdzqDaYkXnOEd";
    String SECRET_KEY = "V9DDOECx7aG5tTmqqfEYlqdrqk6UWL-wdBlmOcQa";

    String bucketname = "maseryi";


    Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    Configuration cfg = new Configuration(Zone.zone1());

    UploadManager uploadManager = new UploadManager(cfg);

    String QINIU_IMAGE_DOMAIN = "http://qw7r9ly4i.hb-bkt.clouddn.com/";

    String upToken = auth.uploadToken(bucketname);

    @Autowired
    GoodsMapper goodsMapper;
    @Override
    public Map<String,Object> saveImage(MultipartFile file,int goodId) {



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
            goodsMapper.changeGoodImg(url,goodId);
            return ResponseMsg.sendMsg(200,"上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseMsg.sendMsg(100,"上传失败",null);

        }

    }

    @Override
    public Map<String, Object> saveSpecImage(MultipartFile file, int id) {
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
            goodsMapper.changeSpecImg(url,id);
            return ResponseMsg.sendMsg(200,"上传成功",url);
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseMsg.sendMsg(100,"上传失败",null);

        }
    }
}
