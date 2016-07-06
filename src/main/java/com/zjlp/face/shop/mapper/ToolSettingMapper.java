package com.zjlp.face.shop.mapper;

import com.zjlp.face.shop.domain.ToolSetting;

public interface ToolSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ToolSetting record);

    int insertSelective(ToolSetting record);

    ToolSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ToolSetting record);

    int updateByPrimaryKey(ToolSetting record);
    
    int update(ToolSetting record);
    
    //通过商铺编号查询ToolSetting
    ToolSetting selectByShopNo(String shopNo);
}