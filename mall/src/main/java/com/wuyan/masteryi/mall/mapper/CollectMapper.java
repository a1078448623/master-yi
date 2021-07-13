package com.wuyan.masteryi.mall.mapper;

import com.wuyan.masteryi.mall.entity.SingleCollectItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Zhao Shuqing
 * @Date: 2021/7/6 16:30
 * @Description:
 */

@Repository
@Mapper
public interface CollectMapper {
    int addToCollect(Integer userId, Integer specsId);
    int deleteFromCollect(Integer collectId);
    List<SingleCollectItem> showMyCollect(Integer userId);
    Integer isCollect(Integer userId, Integer specId);
    Integer getGoodByCollectId(Integer collectId);
}
