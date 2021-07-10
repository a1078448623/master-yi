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

    @ApiOperation(value="添加属性键", notes="添加属性键")
    @PostMapping("/addattrkey")
    public Map<String, Object> addAttrKey (Integer categoryId, String attrKeyName){
        return categoryService.addAttrKey(categoryId, attrKeyName);
    }

    @ApiOperation(value="添加属性值", notes="添加属性值")
    @PostMapping("/addattrvalue")
    public Map<String, Object> addAttrValue (Integer attrKeyId, String attrValueName){
        return categoryService.addAttrValue(attrKeyId, attrValueName);
    }

    @ApiOperation(value="删除属性键", notes="删除属性键")
    @PostMapping("/deleteattrkey")
    public Map<String, Object> deleteAttrKey(Integer attrKeyId){
        return categoryService.deleteAttrKey(attrKeyId);
    }

    @ApiOperation(value="删除属性值", notes="删除属性值")
    @PostMapping("/deleteattrvalue")
    public Map<String, Object> deleteAttrValue(Integer attrValueId){
        return categoryService.deleteAttrValue(attrValueId);
    }

    @ApiOperation(value="更改属性键名字", notes="更改属性键名字")
    @PostMapping("/changeattrkey")
    public Map<String, Object> changeAttrKey(Integer attrKeyId, String newKeyName){
        return categoryService.changeAttrKey(attrKeyId, newKeyName);
    }

    @ApiOperation(value="更改属性值名字", notes="更改属性值名字")
    @PostMapping("/changeattrvalue")
    public Map<String, Object> changeAttrValue(Integer attrValueId, String newValueName){
        return categoryService.changeAttrValue(attrValueId, newValueName);
    }

    @ApiOperation(value = "根据key获得属性",notes = "根据key获得属性")
    @PostMapping("/getValuesByKey")
    public Map<String,Object> getKeyValueMap(int key_id){
        return categoryService.getKeyMapValue(key_id);
    }
}
