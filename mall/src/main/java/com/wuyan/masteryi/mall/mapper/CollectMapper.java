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
    public int addToCollect(Integer userId, Integer goodsId);
    public int deleteFromCollect(Integer collectId);
}
