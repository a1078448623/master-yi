package com.wuyan.masteryi.admin.service;

import com.wuyan.masteryi.admin.entity.AttrItem;
import com.wuyan.masteryi.admin.entity.Category;
import com.wuyan.masteryi.admin.entity.GoodSpecs;
import com.wuyan.masteryi.admin.mapper.CategoryMapper;
import com.wuyan.masteryi.admin.mapper.GoodsMapper;
import com.wuyan.masteryi.admin.utils.ResponseMsg;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Attr;

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

    @Autowired
    GoodsMapper goodsMapper;

    @Autowired
    GoodsService goodsService;

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
        Map<String,List<AttrItem>> res = new HashMap<>();
        List<Integer> ids=categoryMapper.getKeyIds(categoryId);
        List<AttrItem> attrs=new ArrayList<>();
        for (int id :ids){
            List<AttrItem> allAttrItem = categoryMapper.getAllAttrItem(id);
            String name = categoryMapper.getNameById(id);
            if(allAttrItem.size()==0) {
                List<AttrItem> attrItemList=new ArrayList<>();
                attrItemList.add(new AttrItem(categoryId, id + "", name, "0", ""));

                res.put(name,attrItemList );
            }
            else res.put(name,allAttrItem);
        }

//        System.out.println(attrs);
//
//        Set<String> key = new HashSet<String>();
//        for(AttrItem attr:attrs){
//            key.add(attr.getKeyName());
//        }
//        for(String perkey:key) {
//            List<AttrItem> perlist = new ArrayList<>();
//            for(AttrItem attr:attrs) {
//                if(attr.getKeyName().equals(perkey)) {
//                    perlist.add(attr);
//                }
//            }
//            res.put(perkey,perlist);
//        }
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
    public Map<String, Object> deleteAttrKey(Integer attrKeyId,int categoryId) {

        List<Integer> goodIdsByCateId = categoryMapper.getGoodIdsByCateId(categoryId);
        categoryMapper.deleteAttrKey(attrKeyId);
        for(int goodId:goodIdsByCateId){
            List<GoodSpecs> specses = goodsMapper.getAllSpecs(goodId);
            for(GoodSpecs goodSpecs:specses){
                //List<Integer> keys=new ArrayList<>();
                List<Integer> values=new ArrayList<>();
                String[] split = goodSpecs.getSpecs().split(",");
                for(String s:split){
                    if(!s.split(":")[0].equals(attrKeyId + "")){
                        values.add(Integer.parseInt(s.split(":")[1]));
                    }
                }
                if(values.size()!=0){
                    int [] valueIds=new int[values.size()];
                    for(int i=0;i<values.size();i++) valueIds[i]=values.get(i);
                    goodsService.changeSpecs(goodSpecs.getId(),valueIds);
                }
                else categoryMapper.delSpecsById(goodSpecs.getId());
            }
        }
        return ResponseMsg.sendMsg(200, "成功删除所选属性键", "ok");
    }

    @Override
    public Map<String, Object> deleteAttrValue(Integer attrValueId) {

        int keyId=categoryMapper.fromValGetKey(attrValueId);
        String specs=keyId+":"+attrValueId;
        categoryMapper.delSpecsBySpecs(specs);
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
