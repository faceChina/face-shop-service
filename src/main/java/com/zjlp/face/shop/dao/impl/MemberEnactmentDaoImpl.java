package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.MemberEnactmentDao;
import com.zjlp.face.shop.domain.MemberEnactment;
import com.zjlp.face.shop.mapper.MemberEnactmentMapper;

@Repository("MemberEnactmentDao")
public class MemberEnactmentDaoImpl implements MemberEnactmentDao {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public void addMemberEnactment(MemberEnactment memberEnactment) {
		sqlSession.getMapper(MemberEnactmentMapper.class).insertSelective(memberEnactment);
	}

	@Override
	public MemberEnactment getByUserId(Long userId) {
		return sqlSession.getMapper(MemberEnactmentMapper.class).selectByUserId(userId);
	}

}
