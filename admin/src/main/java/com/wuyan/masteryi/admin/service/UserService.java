package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.User;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 14:20
 * @Description:
 */
public interface UserService {
    Map<String,Object> getAllUser();
    Map<String,Object> addUser(String userName, String userPwd, String userImgUrl, String address, String phoneNum);
    Map<String,Object> deleteUser(Integer[] userId);
    Map<String,Object> changeUser(User user);
}
