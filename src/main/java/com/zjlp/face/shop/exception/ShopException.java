package com.zjlp.face.shop.exception;

import com.zjlp.face.shop.exception.enums.BaseExceptionEnum;
import com.zjlp.face.shop.exception.enums.ShopExceptionEnum;


public class ShopException extends BaseException {

	private static final long serialVersionUID = 7947548307909713234L;

	public ShopException() {
		super();
	}

	public ShopException(String message, Throwable cause) {
		super(message, cause);
	}

	public ShopException(String message) {
		super(message);
	}

	public ShopException(Throwable cause) {
		super(cause);
	}	
	
	public ShopException(BaseExceptionEnum baseExceptionEnum) {
		super(baseExceptionEnum);
	}
	
	public ShopException(BaseExceptionEnum baseExceptionEnum, String... params) {
		super(baseExceptionEnum, params);
	}
	
	public ShopException(BaseExceptionEnum baseExceptionEnum,Throwable cause,String... params) {
		super(baseExceptionEnum,cause,params);
	}

	public ShopException(BaseExceptionEnum baseExceptionEnum, Throwable cause) {
		super(baseExceptionEnum, cause);
	}
	
	// 返回错误信息
	public static ShopExceptionEnum ErrorMsg(Integer ret) {
		switch (ret) {
		case -8:
			return ShopExceptionEnum.SHOP_90006;
		case -21:
			return ShopExceptionEnum.SHOP_90008;
		case -23:
			return ShopExceptionEnum.SHOP_90005;
		case -204:
			return ShopExceptionEnum.SHOP_90007;
		case 40001:
			return ShopExceptionEnum.SHOP_90009;
		case 40013:
			return ShopExceptionEnum.SHOP_90010;
		default:
			return ShopExceptionEnum.SHOP_90003;
		}
	}
}
