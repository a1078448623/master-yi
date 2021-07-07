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
            if (ca.getParentCategoryId()!=null && !parent_ids.contains(ca.getParentCategoryId())) {
                parent_ids.add(ca.getParentCategoryId());
            }
        }
        System.out.println(parent_ids);
        for (Integer parent_id : parent_ids) {
            List<Category> child = new ArrayList<>();
            for (Category ca : allCategory) {
                if (ca.getParentCategoryId()!=null && parent_id.equals(ca.getParentCategoryId())) {
                    child.add(ca);
                }
            }
            data.put(categoryMapper.getCategoryNameById(parent_id), child);
        }
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
}