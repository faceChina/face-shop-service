package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.ShopRoleRelation;

/**
 * 产品与权限关联基础接口
 * @ClassName: ShopRoleRelationService 
 * @Description: (产品与权限关联基础接口) 
 * @author ah
 * @date 2014年7月25日 上午10:28:59
 */
public interface ShopRoleRelationService {

	/**
	 * 新增产品与权限的关联
	 * @Title: addShopRoleRelation 
	 * @Description: (新增产品与权限的关联) 
	 * @param shopRoleRelation
	 * @date 2014年7月25日 上午11:07:27  
	 * @author ah
	 */
	void addShopRoleRelation(ShopRoleRelation shopRoleRelation);

}
