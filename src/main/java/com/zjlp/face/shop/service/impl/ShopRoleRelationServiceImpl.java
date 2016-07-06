package com.zjlp.face.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.ShopRoleRelationDao;
import com.zjlp.face.shop.domain.ShopRoleRelation;
import com.zjlp.face.shop.service.ShopRoleRelationService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ShopRoleRelationServiceImpl implements ShopRoleRelationService {
	
	@Autowired
	private ShopRoleRelationDao shopRoleRelationDao;

	@Override
	public void addShopRoleRelation(ShopRoleRelation shopRoleRelation) {
		shopRoleRelationDao.addShopRoleRelation(shopRoleRelation);
	}

}
