package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.AttrItem;
import com.wuyan.masteryi.admin.entity.Category;
import com.wuyan.masteryi.admin.mapper.CategoryMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 15:28
 * @Description:
 */
@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public Map<String, Object> getAllType() {
        Map<String, List<Category>> data = new HashMap<>();
        List<Integer> parent_ids = new ArrayList<>();
        List<Category> allCategory = categoryMapper.getAllCategory();
        for (Category ca : allCategory) {
            if (ca.getParentCategoryId()==null && !parent_ids.contains(ca.getCategoryId())) {
                parent_ids.add(ca.getCategoryId());
            }
        }
        for (Integer parent_id : parent_ids) {
            List<Category> child = new ArrayList<>();
            for (Category ca : allCategory) {
                if (ca.getParentCategoryId()!=null && parent_id.equals(ca.getParentCategoryId())) {
                    child.add(ca);
                }
            }
            if(child.size()==0){
                child.add(new Category(0,parent_id,"aaa"));
            }
            data.put(categoryMapper.getCategoryNameById(parent_id), child);
        }
        System.out.println(data);
        return ResponseMsg.sendMsg(200, "成功获取分类信息", data);
    }

    @Override
    public Map<String, Object> addCategory(Integer parentId, String categoryName) {
        return ResponseMsg.sendMsg(200, "成功添加新分类", categoryMapper.addCategory(parentId,categoryName));
    }

    @Override
    public Map<String, Object> deleteCategory(Integer categoryId) {
        return ResponseMsg.sendMsg(200, "成功删除该类（及其子类）", categoryMapper.deleteCategory(categoryId));
    }

    @Override
    public Map<String, Object> changeCategoryName(Integer categoryId, String newName) {
        return ResponseMsg.sendMsg(200, "成功更改分类名", categoryMapper.changeCategoryName(categoryId, newName));
    }

    @Override
    public Map<String, Object> getAllAttr(Integer categoryId) {
        List<AttrItem> attrs = categoryMapper.getAllAttrItem(categoryId);
        Map<String,List<AttrItem>> res = new HashMap<>();
        Set<String> key = new HashSet<String>();
        for(AttrItem attr:attrs){
            key.add(attr.getKeyName());
        }
        for(String perkey:key) {
            List<AttrItem> perlist = new ArrayList<>();
            for(AttrItem attr:attrs) {
                if(attr.getKeyName().equals(perkey)) {
                    perlist.add(attr);
                }
            }
            res.put(perkey,perlist);
        }
        return ResponseMsg.sendMsg(200,"查询成功",res);
    }

    @Override
    public Map<String, Object> addAttrKey(Integer categoryId, String attrKeyName) {
        return ResponseMsg.sendMsg(200, "成功添加新属性键", categoryMapper.addAttrKey(categoryId, attrKeyName));
    }

    @Override
    public Map<String, Object> addAttrValue(Integer attrKeyId, String attrValueName) {
        return ResponseMsg.sendMsg(200, "成功添加新属性值", categoryMapper.addAttrValue(attrKeyId, attrValueName));
    }

    @Override
    public Map<String, Object> deleteAttrKey(Integer attrKeyId) {
        return ResponseMsg.sendMsg(200, "成功删除所选属性键", categoryMapper.deleteAttrKey(attrKeyId));
    }

    @Override
    public Map<String, Object> deleteAttrValue(Integer attrValueId) {
        return ResponseMsg.sendMsg(200, "成功删除所选属性值", categoryMapper.deleteAttrValue(attrValueId));
    }

    @Override
    public Map<String, Object> changeAttrKey(Integer attrKeyId, String newKeyName) {
        return ResponseMsg.sendMsg(200, "成功更改所选属性键的名字", categoryMapper.changeAttrKey(attrKeyId, newKeyName));
    }

    @Override
    public Map<String, Object> changeAttrValue(Integer attrValueId, String newValueName) {
        return ResponseMsg.sendMsg(200, "成功更改所选属性值的名字", categoryMapper.changeAttrValue(attrValueId, newValueName));
    }

    @Override
    public Map<String, Object> getKeyMapValue(int key_id) {
        return ResponseMsg.sendMsg(200,"查询成功",categoryMapper.getKeyMapValue(key_id));
    }
}
