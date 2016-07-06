package com.zjlp.face.shop.util;

public class ConstantsUtil {

	/**
	 * 状态  
	 *  -1：删除，1：正常 
	 */
	public static final Integer STATE_DELETE = -1;
	
	public static final Integer STATE_NORMAL = 1;
	
	/** 银行卡用途：2:结算 */
	public static final Integer USE_TYPE = 2;
	
	/** 是否为默认银行卡：1、默认 */
	public static final Integer DEFAULT_TYPE = 1;
	/** 是否为默认银行卡：0、普通卡 */
	public static final Integer COMMEN_TYPE = 0;
	
	/**
	 * 话费价格表状态：1.正常2.维护中
	 */
	public static final Integer PHONE_PRICE_NORMAL = 1;
	public static final Integer PHONE_PRICE_MAINTAIN = 2;
	
	/**
	 * 产品权限
	 * 4:官网 5:商城 6:脸谱 11:微平台
	 */
	public static final Long ROLE_GW = Long.valueOf(4);
	public static final Long ROLE_SC = Long.valueOf(5);
	public static final Long ROLE_LP = Long.valueOf(6);
	public static final Long ROLE_PF = Long.valueOf(11);
	
	/**
	 * 产品分类
	 * 1：官网 2：商城 3：脸谱 9:微平台
	 */
	public static final Integer CLASSIFICATION_GW = 1;
	public static final Integer CLASSIFICATION_SC = 2;
	public static final Integer CLASSIFICATION_LP = 3;
	public static final Integer CLASSIFICATION_PF = 9;
	
	/**
	 * 钱包类型
	 * 0：系统用户钱包 1：普通用户钱包 2：产品收益钱包 3：平台钱包 4：连连钱包
	 */
	public static final Integer SHOP_TYPE = 2;
	
	/**
	 * 银行卡类型
	 *  2、借记卡 3、信用卡
	 */
	public static final Integer BANK_TYPE_STORE = 2;
	
	/**
	 * 支付类型
	 * 2.快捷支付（借记卡）3.快捷支付（信用卡）
	 */
	public static final Integer PAY_TYPE_STORE = 2;
}
