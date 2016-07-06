package com.zjlp.face.shop.service;

import java.util.ArrayList;

import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.WechatDevInfo;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;

public interface WechatService {

	/**
	 * 绑定微信号
	 * @Title: bindShop 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param dto
	 * @date 2014年7月18日 下午4:44:24  
	 * @author ah
	 */
	void bindShop(ShopDto dto) throws ShopException;
	
	/**
	 * 发送模板消息
	 * @Title: sendTemplateMessage 
	 * @Description: (发送模板消息) 
	 * @param openId
	 * @param templateId
	 * @param paramList
	 * @param messageData
	 * @param accessToKen
	 * @param url
	 * @throws ShopException
	 * @date 2015年3月11日 下午5:21:54  
	 * @author ah
	 */
	Integer sendTemplateMessage(String openId, String templateId, ArrayList<String> paramList, 
			Class<? extends TemplateMessageData> messageData, String accessToKen, String url) throws ShopException;
	
	/**
	 * 验证开发者信息
	 * @Title: checkDeveleperInfo 
	 * @Description: (验证开发者信息) 
	 * @param appId
	 * @param appSecret
	 * @throws ShopException
	 * @date 2015年3月5日 下午2:43:15  
	 * @author ah
	 */
	void checkDeveleperInfo(String appId, String appSecret) throws ShopException;
	
	/**
	 * 获取网页授权信息
	 * @Title: getDynamicAccessoken 
	 * @Description: (获取网页授权信息) 
	 * @param code
	 * @param devInfo
	 * @return
	 * @date 2015年3月11日 下午4:50:14  
	 * @author ah
	 */
	GrandInfo getDynamicAccessoken(String code, WechatDevInfo devInfo);
	
	/**
	 * 设置模板消息所属行业
	 * @Title: setIndustry 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param accessToken
	 * @return
	 * @date 2015年4月29日 下午2:59:31  
	 * @author ah
	 */
	void setIndustry(String accessToken) throws ShopException;
	
	/**
	 * 获取模板id
	 * @Title: getTemplateId 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @throws ShopException
	 * @date 2015年4月29日 下午4:27:15  
	 * @author ah
	 */
	String getTemplateId(Integer type, String accessToken) throws ShopException;
	
	/**
	 * 生成菜单
	 * @Title: generateMenu 
	 * @Description: (返回0时，成功生成菜单，非0时，生成菜单失败) 
	 * @param menu
	 * @param accessToken
	 * @return
	 * @throws ShopException
	 * @date 2015年4月29日 下午5:46:41  
	 * @author ah
	 */
	Integer generateMenu(String menu, String accessToken) throws ShopException;
}
