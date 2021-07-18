package com.wuyan.masteryi.admin.controller;

import com.wuyan.masteryi.admin.service.GoodsService;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Api(tags="商品管理接口")
@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @ApiOperation(value="获取全部商品", notes="获取全部商品")
    @PostMapping("/getallgoods")
    public Map<String, Object> getAllGoods(HttpServletResponse response){
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        return goodsService.getAllGoods();}

    @ApiOperation(value="获取某父类下的商品", notes="获取某父类下的商品")
    @PostMapping("/getparentcategorygoods")
    public Map<String, Object> getParentCategoryGoods(Integer parentId){ return goodsService.getParentCategoryGoods(parentId);}

    @ApiOperation(value="获取某子类下的商品", notes="获取某子类下的商品")
    @PostMapping("/getchildcategorygoods")
    public Map<String, Object> getChildCategoryGoods(Integer childId){ return goodsService.getChildCategoryGoods(childId);}

    @ApiOperation(value="获取该商品全部属性", notes="获取该商品全部属性")
    @PostMapping("/getallgoodspecs")
    @Transactional
    public Map<String, Object> getAllSpecs(Integer []goods_id) {
        return goodsService.getAllSpecs(goods_id);
    }

    @ApiOperation(value="添加商品", notes="添加商品")
    @PostMapping("/addgood")
    public Map<String, Object> addGood(String goodsName, String goodsInformation, Integer goodsCategoryId,
                                       String goodsCoverUrl, Integer collectNum, Integer sellNum,int [] specs,float primaryPrice) {
        return goodsService.addGood(goodsName, goodsInformation, goodsCategoryId, goodsCoverUrl, collectNum, sellNum,specs,primaryPrice);
    }

    @ApiOperation(value="添加商品属性", notes="添加商品属性")
    @PostMapping("/addspec")
    public Map<String, Object> addSpecs(Integer goodsId, int[] specs, Integer stock, float price) {
        return goodsService.addSpecs(goodsId, specs, stock, price);
    }

    @ApiOperation(value="改变商品库存", notes="改变商品库存")
    @PostMapping("/changstock")
    public Map<String, Object> changeStock(Integer newStock, Integer goodSpecsId) {
        return goodsService.changeStock(newStock, goodSpecsId);
    }

    @ApiOperation(value="改变商品价格", notes="改变商品价格")
    @PostMapping("/changeprice")
    public Map<String, Object> changePrice(float newPrice, Integer goodSpecsId) {
        return goodsService.changePrice(newPrice, goodSpecsId);
    }

    @ApiOperation(value="删除商品属性", notes="删除商品属性")
    @PostMapping("/deletespecs")
    public Map<String, Object> deleteSpecs(Integer goodSpecsId) {
        return goodsService.deleteSpecs(goodSpecsId);
    }

    @ApiOperation(value="删除商品", notes="删除商品")
    @PostMapping("/deleteGoods")
    public Map<String, Object> deleteGoods(Integer goodsId) {
        return goodsService.deleteGoods(goodsId);
    }

    @ApiOperation(value="某特征的描述", notes="某特征的描述")
    @PostMapping("/getDescp")
    public Map<String,Object> getDescp(int id){
        return goodsService.getSpecsDesc(id);
    }
    @PostMapping("/goodTest")
    @Transactional
    @ApiOperation(value = "商品详细分类",notes = "根据id获得商品详细分类")
    public Map<String,Object> getGoodTypes(int good_id){
        return goodsService.getGoodTypes(good_id);
    }

    @PostMapping("/valuesByKey")
    @ApiOperation(value = "根据key获得values",notes = "根据key获得values")
    public Map<String,Object> getValuesByKey(int []key_id){
        return goodsService.getValuesByKey(key_id);
    }

    @PostMapping("/getgoodbysid")
    @ApiOperation(value = "根据特征id获得商品",notes = "根据特征id获得商品")
    Map<String, Object> getGoodBySpecsId(int id){
        return goodsService.getGoodBySpecsId(id);
    }
}
