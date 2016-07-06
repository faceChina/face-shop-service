package com.zjlp.face.shop.mapper;

import java.util.List;

import com.zjlp.face.shop.domain.Member;

public interface MemberMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Member member);

    int insertSelective(Member member);

    Member selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Member member);

    int updateByPrimaryKey(Member member);
    
    List<Member> selectMembers(Member member);
}