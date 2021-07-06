package com.wuyan.masteryi.mall.entity;

import lombok.Data;
import java.util.Date;

@Data
public class Collect {
    private Integer collectId;
    private Integer userId;
    private Integer goodsId;
    private Date collectTime;
}
