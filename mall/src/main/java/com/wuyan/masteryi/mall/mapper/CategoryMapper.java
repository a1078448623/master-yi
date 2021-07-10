package com.wuyan.masteryi.mall.mapper;

import com.wuyan.masteryi.mall.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:50
 * @Description:
 */

@Repository
@Mapper
public interface CategoryMapper {
    List<Category> getAllCategory();
    String getCategoryNameById(Integer cid);
}
