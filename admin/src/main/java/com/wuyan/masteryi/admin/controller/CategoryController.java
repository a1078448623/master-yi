package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/7 15:32
 * @Description:
 */

@Api(tags="分类管理接口")
@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @ApiOperation(value="获取全部分类", notes="获取全部分类")
    @PostMapping("/getallcategory")
    public Map<String, Object> getAllType(){
        return categoryService.getAllType();
    }

    @ApiOperation(value="添加新分类", notes="添加新分类")
    @PostMapping("/addcategory")
    public Map<String, Object> addCategory(Integer parentId, String categoryName){
        return categoryService.addCategory(parentId, categoryName);
    }

    @ApiOperation(value="删除分类", notes="删除分类")
    @PostMapping("/deletecategory")
    public Map<String, Object> deleteCategory(Integer categoryId){
        return categoryService.deleteCategory(categoryId);
    }

    @ApiOperation(value="更改分类名", notes="更改分类名")
    @PostMapping("/changecategoryname")
    public Map<String, Object> changeCategoryName(Integer categoryId,String newName){
        return categoryService.changeCategoryName(categoryId,newName);
    }

    @ApiOperation(value="获取规格", notes="获取规格")
    @PostMapping("/getallattr")
    public Map<String, Object> getAllAttr(Integer categoryId){
        return categoryService.getAllAttr(categoryId);
    }


}
