package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.ShopRoleRelationDao;
import com.zjlp.face.shop.domain.ShopRoleRelation;
import com.zjlp.face.shop.mapper.ShopRoleRelationMapper;

@Repository("ShopRoleRelationDao")
public class ShopRoleRelationDaoImpl implements ShopRoleRelationDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addShopRoleRelation(ShopRoleRelation shopRoleRelation) {
		sqlSession.getMapper(ShopRoleRelationMapper.class).insert(shopRoleRelation);
	}

}
