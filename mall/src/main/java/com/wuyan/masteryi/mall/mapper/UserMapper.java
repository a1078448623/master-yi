package com.wuyan.masteryi.mall.mapper;
/*
 *project:master-yi
 *file:UserMapper
 *@author:wsn
 *date:2021/7/6 18:25
 */

import com.wuyan.masteryi.mall.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User getUserByNP(String username,String password);
    void setAddr(int u_id,String address);
    String getAddr (int u_id);
    void setPhoneNum(int u_id,String phoneNum);
    int addUser(String username,String password);
    void setImg(int u_id,String imgurl);
    User isNameRep(String username);
    User isPhoneRep(String phoneNum);
    int addConsumption(int userId, float money);
    String getUserId(String username);
    User getUser(Integer userId);
    void changeUserInfo(Integer userId,String userName,String userPwd,String phoneNum,String userAddress, String userImgUrl);
    void chengImgUrl(String url,int u_id);
}
