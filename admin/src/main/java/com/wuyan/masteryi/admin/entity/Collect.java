package com.wuyan.masteryi.admin.entity;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class Collect {
    private Integer collectId;
    private Integer userId;
    private Integer goodsId;
    private Date collectTime;
}
