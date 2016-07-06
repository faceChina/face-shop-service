package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.ManagedAccountsShopReferenceDao;
import com.zjlp.face.shop.mapper.ManagedAccountsShopReferenceMapper;

@Repository("ManagedAccountsShopReferenceDao")
public class ManagedAccountsShopReferenceDaoImpl implements
		ManagedAccountsShopReferenceDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void deleteManagedAccountsShopReferenceByShopNo(String shopNo) {
		sqlSession.getMapper(ManagedAccountsShopReferenceMapper.class).deleteByShopNo(shopNo);

	}

}
