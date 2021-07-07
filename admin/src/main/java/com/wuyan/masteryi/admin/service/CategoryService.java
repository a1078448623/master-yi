package com.wuyan.masteryi.admin.service;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 15:27
 * @Description:
 */
public interface CategoryService {
    Map<String, Object> getAllType();
    Map<String, Object> addCategory(Integer parentId, String categoryName);
    Map<String, Object> deleteCategory(Integer categoryId);
    Map<String, Object> changeCategoryName(Integer categoryId, String newName);
    Map<String, Object> getAllAttr(Integer categoryId);
}
