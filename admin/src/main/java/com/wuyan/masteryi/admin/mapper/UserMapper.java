package com.wuyan.masteryi.admin.mapper;

import com.wuyan.masteryi.admin.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 14:12
 * @Description:
 */

@Repository
@Mapper
public interface UserMapper {
    List<User> getAllUser();
    int addUser(String userName, String userPwd, String userImgUrl, String address, String phoneNum);
    void deleteUser(Integer userId);
    int changeUser(@Param("user") User user);
    void changImgUrl(String url,int u_id);
}













