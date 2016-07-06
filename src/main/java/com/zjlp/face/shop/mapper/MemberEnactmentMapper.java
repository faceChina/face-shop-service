package com.zjlp.face.shop.mapper;

import com.zjlp.face.shop.domain.MemberEnactment;

public interface MemberEnactmentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MemberEnactment record);

    int insertSelective(MemberEnactment record);

    MemberEnactment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MemberEnactment record);

    int updateByPrimaryKeyWithBLOBs(MemberEnactment record);

    int updateByPrimaryKey(MemberEnactment record);

	MemberEnactment selectByUserId(Long userId);
}