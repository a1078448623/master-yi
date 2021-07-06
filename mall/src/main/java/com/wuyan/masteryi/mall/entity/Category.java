package com.wuyan.masteryi.mall.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 10:30
 * @Description:
 */

@Data
public class Category {
    private Integer categoryId;
    private Integer parentCategoryId;
    private String categoryName;
}
