package com.wuyan.masteryi.mall.controller;

import com.wuyan.masteryi.mall.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:50
 * @Description:
 */

@Api(tags="分类接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation(value="获取分类", notes="获取分类")
    @PostMapping("/getallcategory")
    public Map<String, Object> getAllType(){
        return categoryService.getAllType();
    }

    @ApiOperation(value="根据id获取分类名", notes="根据id获取分类名")
    @PostMapping("/getcategorynamebyid")
    public Map<String, Object> getCategoryNameById(Integer cid){
        return categoryService.getCategoryNameById(cid);
    }
}
