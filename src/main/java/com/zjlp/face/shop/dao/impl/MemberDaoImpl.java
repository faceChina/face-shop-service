package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.MemberDao;
import com.zjlp.face.shop.domain.Member;
import com.zjlp.face.shop.mapper.MemberMapper;

@Repository("MemberDao")
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addMember(Member member) {
		sqlSession.getMapper(MemberMapper.class).insertSelective(member);
	}
}
