package com.wuyan.masteryi.mall.entity;

import lombok.Data;

@Data
public class Category {
    private Integer categoryId;
    private Integer parentCategoryId;
    private String categoryName;
}
