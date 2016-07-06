package com.zjlp.face.shop.dao;

/**
 * 管理账户商铺关联关系持久层
 * @ClassName: ManagedAccountsShopReferenceDao 
 * @Description: (管理账户商铺关联关系持久层) 
 * @author ah
 * @date 2014年7月26日 下午5:51:28
 */
public interface ManagedAccountsShopReferenceDao {

	/**
	 * 根据产品编号删除管理账户商铺关联关系
	 * @Title: deleteManagedAccountsShopReferenceByShopNo 
	 * @Description: (根据产品编号删除管理账户商铺关联关系) 
	 * @param shopNo
	 * @date 2014年7月26日 下午5:52:35  
	 * @author ah
	 */
	void deleteManagedAccountsShopReferenceByShopNo(String shopNo);

}
