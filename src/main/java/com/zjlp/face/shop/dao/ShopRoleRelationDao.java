package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.ShopRoleRelation;

/**
 * 产品与权限关联持久层
 * @ClassName: ShopRoleRelationDao 
 * @Description: (产品与权限关联持久层) 
 * @author ah
 * @date 2014年7月25日 上午11:18:21
 */
public interface ShopRoleRelationDao {

	/**
	 * 新增产品与权限关联关系
	 * @Title: addShopRoleRelation 
	 * @Description: (新增产品与权限关联关系) 
	 * @param shopRoleRelation
	 * @date 2014年7月25日 上午11:19:28  
	 * @author ah
	 */
	void addShopRoleRelation(ShopRoleRelation shopRoleRelation);

}
