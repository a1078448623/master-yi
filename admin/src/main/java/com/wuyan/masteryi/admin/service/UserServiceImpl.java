package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.User;
import com.wuyan.masteryi.admin.mapper.UserMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 14:22
 * @Description:
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, Object> getAllUser() {
        return ResponseMsg.sendMsg(200, "成功获取所有用户信息", userMapper.getAllUser());
    }

    @Override
    public Map<String, Object> addUser(String userName, String userPwd, String userImgUrl, String address, String phoneNum) {
        return ResponseMsg.sendMsg(200, "成功添加用户", userMapper.addUser(userName, userPwd, userImgUrl, address, phoneNum));
    }

    @Override
    public Map<String, Object> deleteUser(Integer[] userIds) {
        for(Integer userId:userIds) {
            userMapper.deleteUser(userId);
        }
        return ResponseMsg.sendMsg(200, "成功删除所选用户", 1);
    }

    @Override
    public Map<String, Object> changeUser(User user) {
        return ResponseMsg.sendMsg(200, "成功更改用户信息", userMapper.changeUser(user));
    }

    @Override
    public String getUserId(String username) {
        return userMapper.getUserId(username);
    }

    @Override
    public Map<String, Object> getUserByNP(String username, String password) {
        User user= userMapper.getUserByNP(username,password);
        if(user==null) return ResponseMsg.sendMsg(100,"用户名或密码错误",null);
        else return ResponseMsg.sendMsg(200,"查询到用户",true);
    }
}
