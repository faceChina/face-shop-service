package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.MessageSetting;

/**
 * 消息设置基础服务接口
 * @ClassName: MessageSettingService 
 * @Description: (消息设置基础服务接口) 
 * @author ah
 * @date 2014年8月1日 上午9:58:18
 */
public interface MessageSettingService {

	/**
	 * 根据产品编号查询消息设置
	 * @Title: slectByShopNo 
	 * @Description: (根据产品编号查询消息设置) 
	 * @param messageSetting
	 * @return
	 * @date 2014年8月1日 上午9:57:18  
	 * @author ah
	 */
	MessageSetting getMessageSettingByShopNo(MessageSetting messageSetting);

}
