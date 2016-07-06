package com.zjlp.face.shop.mapper;

import java.util.Map;

import com.zjlp.face.shop.domain.Admin;

public interface AdminMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);
    
    Admin getAdminByNameAndPasswd(Map<String, String> map);
}