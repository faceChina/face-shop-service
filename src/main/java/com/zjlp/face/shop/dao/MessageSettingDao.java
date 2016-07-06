package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.MessageSetting;

/**
 * 消息设置持久层
 * @ClassName: MessageSettingDao 
 * @Description: (消息设置持久层) 
 * @author ah
 * @date 2014年8月1日 上午10:02:04
 */
public interface MessageSettingDao {

	/**
	 * 根据产品编号查询消息设置
	 * @Title: getMessageSettingByShopNo 
	 * @Description: (根据产品编号查询消息设置) 
	 * @param messageSetting
	 * @return
	 * @date 2014年8月1日 上午10:02:37  
	 * @author ah
	 */
	MessageSetting getMessageSettingByShopNo(MessageSetting messageSetting);

}
