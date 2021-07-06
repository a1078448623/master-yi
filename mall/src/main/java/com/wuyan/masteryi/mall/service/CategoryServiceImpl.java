package com.wuyan.masteryi.mall.service;

import com.wuyan.masteryi.mall.entity.Category;
import com.wuyan.masteryi.mall.mapper.CategoryMapper;
import com.wuyan.masteryi.mall.utils.ResponseMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:50
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
}
