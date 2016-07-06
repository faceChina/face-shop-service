package com.zjlp.face.shop.factory;

import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;

public interface ShopFactory {
	
	/**
	 * 新增产品
	 * @Title: addShop 
	 * @Description: (新增产品) 
	 * @param dto
	 * @date 2014年7月17日 下午9:44:33  
	 * @author ah
	 */
	public Shop addShop(ShopDto dto) throws ShopException;
	
}
