package com.zjlp.face.shop.factory.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlp.face.account.service.AccountService;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;
import com.zjlp.face.shop.exception.enums.ShopExceptionEnum;
import com.zjlp.face.shop.factory.ShopFactory;
import com.zjlp.face.shop.service.ShopService;
import com.zjlp.face.shop.service.UserService;
import com.zjlp.face.shop.util.AssertUtil;
import com.zjlp.face.shop.util.GenerateCode;

/**
 * 免费店铺生产
 * @ClassName: FreeShopFactory 
 * @Description: (免费店铺生产) 
 * @author ah
 * @date 2015年1月5日 下午2:29:10
 */
@Service("freeShopFactory")
public class FreeShopFactory implements ShopFactory {
	
	@Autowired
	private ShopService shopService;
	
	@Autowired
	private UserService userService;
	
	@Autowired(required = false)
    private AccountService accountService;
	
	private Logger _shopInfoLog = Logger.getLogger("shopInfoLog");
    
    private Logger _shopErrorLog = Logger.getLogger("shopErrorLog");

	@Override
	public Shop addShop(ShopDto shopDto) throws ShopException {
		// 店铺类型
		Integer type = shopDto.getType();
		try {
			// 1.查询注册用户
			_shopInfoLog.info("新增免费店铺开始！");
            User user = userService.getUserById(shopDto.getUserId());
            AssertUtil.notNull(user, ShopException.class, ShopExceptionEnum.SHOP_10001);
            // 2.生产免费店铺
			// 生成产品编号
	        String no = GenerateCode.generateShopNo(type);
	        AssertUtil.notNull(no, ShopException.class, ShopExceptionEnum.SHOP_00004);
	        Shop shop = Shop._generateShop(no, user, shopDto);
	        _shopInfoLog.info("店铺详情："+shop);
	        shopService.addShop(shop);
	        // 3.产品钱包
	        accountService.addAccount(shop.getNo(), shop.getCell(), null, null, null);
            _shopInfoLog.info("新增免费店铺结束！");
            return shop;
		} catch(ShopException e){
			_shopErrorLog.error(e.getMessage());
            throw e;
        } catch(Exception e){
        	_shopErrorLog.error(e.getMessage());
            throw new ShopException(e);
        }
	}


}
