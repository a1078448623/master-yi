package com.wuyan.masteryi.admin.mapper;

import com.wuyan.masteryi.admin.entity.AttrItem;
import com.wuyan.masteryi.admin.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 15:26
 * @Description:
 */
@Mapper
@Repository
public interface CategoryMapper {
    List<Category> getAllCategory();
    String getCategoryNameById(Integer categoryId);
    int addCategory(Integer parentId,String categoryName);
    int deleteCategory(Integer categoryId);
    int changeCategoryName(Integer categoryId, String newName);
    List<AttrItem> getAllAttrItem(Integer categoryId);
    int addAttrKey(Integer categoryId, String attrKeyName);
    int addAttrValue(Integer attrKeyId, String attrValueName);
    int deleteAttrKey(Integer attrKeyId);
    int deleteAttrValue(Integer attrValueId);
    int changeAttrKey(Integer attrKeyId, String newKeyName);
    int changeAttrValue(Integer attrValueId, String newValueName);
    List<AttrItem> getKeyMapValue(int key_id);
}
