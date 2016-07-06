package com.zjlp.face.shop.mapper;

import com.zjlp.face.shop.domain.ShopRoleRelation;

public interface ShopRoleRelationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ShopRoleRelation record);

    int insertSelective(ShopRoleRelation record);

    ShopRoleRelation selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ShopRoleRelation record);

    int updateByPrimaryKey(ShopRoleRelation record);
}