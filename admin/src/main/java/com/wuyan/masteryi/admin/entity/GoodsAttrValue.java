package com.wuyan.masteryi.admin.entity;
/*
 *project:master-yi
 *file:GoddsAttrValue
 *@author:wsn
 *date:2021/7/7 12:31
 */

import lombok.Data;

@Data
public class GoodsAttrValue {
    private int id;
    private int attrKeyId;
    private String keyName;
    private String valueName;
}
