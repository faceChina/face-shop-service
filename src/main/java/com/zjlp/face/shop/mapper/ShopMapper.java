package com.zjlp.face.shop.mapper;

import java.util.List;
import java.util.Map;

import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;

public interface ShopMapper {

    int deleteByPrimaryKey(String no);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String no);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKeyWithBLOBs(Shop record);

    int updateByPrimaryKey(Shop record);

    List<ShopDto> selectList(Map<String, Object> map);

    Integer getCount(ShopDto dto);

    Shop selectShop(Shop shop);

    Shop selectByWechat(Shop shop);

    void updateShop(Shop shop);

    void deleteGoodRecommend(String shopNo);

	Integer getShopCountByUserId(Long userId);
}
