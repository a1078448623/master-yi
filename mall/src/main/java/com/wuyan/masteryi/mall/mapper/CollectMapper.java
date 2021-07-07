package com.wuyan.masteryi.mall.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

@Repository
@Mapper
public interface CollectMapper {
    int addToCollect(Integer userId, Integer goodsId);
    int deleteFromCollect(Integer collectId);
}
