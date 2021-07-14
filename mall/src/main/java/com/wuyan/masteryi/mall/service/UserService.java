package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:UserService
 *@author:wsn
 *date:2021/7/6 18:25
 */

import com.wuyan.masteryi.mall.entity.User;

import java.util.Map;

public interface UserService {

    Map<String,Object> getUserByNP(String username, String password);
    Map<String,Object> setAddr(int u_id,String address);
    Map<String,Object> setPhoneNum(int u_id,String phoneNum);
    Map<String,Object> addUser(String username,String password);
    Map<String,Object> setImg(int u_id,String imgurl);
    Map<String,Object> isNameRep(String username);
    Map<String,Object> isPhoneRep(String phoneNum);
    String getUserId(String username);
    Map<String,Object> getUser(Integer userId);
    Map<String,Object> changeUserInfo(Integer userId,String userName,String userPwd,String phoneNum,String userAddress, String userImgUrl);

}
