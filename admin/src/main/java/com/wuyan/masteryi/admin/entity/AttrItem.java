package com.wuyan.masteryi.admin.entity;

import lombok.Data;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 16:50
 * @Description:
 */

@Data
public class AttrItem {
    private Integer categoryId;
    private String keyId;
    private String keyName;
    private String valueId;
    private String valueName;

    public AttrItem(Integer categoryId, String keyId, String keyName, String valueId, String valueName) {
        this.categoryId = categoryId;
        this.keyId = keyId;
        this.keyName = keyName;
        this.valueId = valueId;
        this.valueName = valueName;
    }
}
