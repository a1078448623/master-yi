package com.wuyan.masteryi.mall.service;
/*
 *project:master-yi
 *file:UserServiceImpl
 *@author:wsn
 *date:2021/7/6 18:25
 */

import com.wuyan.masteryi.mall.entity.User;
import com.wuyan.masteryi.mall.mapper.UserMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserMapper userMapper;
    @Override
    public Map<String, Object> getUserByNP(String username, String password) {
        User user= userMapper.getUserByNP(username,password);
        if(user==null) return ResponseMsg.sendMsg(100,"用户名或密码错误",null);
        else return ResponseMsg.sendMsg(200,"查询到用户",true);
    }

    @Override
    public Map<String, Object> setAddr(int u_id, String address) {
        userMapper.setAddr(u_id,address);
        return ResponseMsg.sendMsg(200,"设置成功",true);
    }

    @Override
    public Map<String, Object> setPhoneNum(int u_id, String phoneNum) {
        if((int)isPhoneRep(phoneNum).get("code")==100){
            return ResponseMsg.sendMsg(100,"手机号已被使用",false);
        }
        else {
            userMapper.setPhoneNum(u_id,phoneNum);
            return ResponseMsg.sendMsg(200,"设置成功",true);
        }
    }

    @Override
    public Map<String, Object> addUser(String username, String password) {
        if((int)isNameRep(username).get("code")==100) return ResponseMsg.sendMsg(100,"用户名已被占用",false);
        else {
            userMapper.addUser(username, password);
            return ResponseMsg.sendMsg(200,"用户添加成功",true);
        }
    }

    @Override
    public Map<String, Object> setImg(int u_id, String imgurl) {
        userMapper.setImg(u_id,imgurl);
        return ResponseMsg.sendMsg(200,"设置成功",true);
    }

    @Override
    public Map<String, Object> isNameRep(String username) {

        User i=userMapper.isNameRep(username);
        if(i!=null) return ResponseMsg.sendMsg(100,"已重复",true);
        else return ResponseMsg.sendMsg(200,"没有重复",false);
    }

    @Override
    public Map<String, Object> isPhoneRep(String phoneNum) {
        User i=userMapper.isPhoneRep(phoneNum);
        if(i!=null) return ResponseMsg.sendMsg(100,"已重复",true);
        else return ResponseMsg.sendMsg(200,"没有重复",false);
    }

    @Override
    public String getUserId(String username) {
        return userMapper.getUserId(username);
    }

    @Override
    public Map<String, Object> getUser(Integer userId) {
        return ResponseMsg.sendMsg(200,"没有重复",userMapper.getUser(userId));
    }


    @Override
    public Map<String, Object> changeUserInfo(Integer userId, String userName, String userPwd, String phoneNum, String userAddress, String userImgUrl) {
        userMapper.changeUserInfo(userId, userName, userPwd,phoneNum,userAddress,userImgUrl);
        return ResponseMsg.sendMsg(200,"更改成功",1);
    }
}
