package com.zjlp.face.shop.service;

import java.util.ArrayList;

import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.WechatDevInfo;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;

/**
 * 店铺对外服务接口
 * @ClassName: ShopExternalService 
 * @Description: (店铺对外服务接口) 
 * @author ah
 * @date 2015年1月6日 上午10:38:41
 */
public interface ShopExternalService{
	// 新增微小店
	Shop addSmallShop(ShopDto dto) throws ShopException;
	// 新增普通店铺
	Shop addCommonShop(ShopDto dto) throws ShopException;
	// 新增免费店铺
	Shop addFreeShop(ShopDto dto) throws ShopException;
	// 对店铺绑定微信号
	void bindShop(ShopDto dto) throws ShopException;
	// 获取AccessToken
	String getAccessToken(String appId, String appSecret) throws ShopException;
	// 直接从微信端获取token
	String getAccessTokenFromWechat(String appId, String appSecret) throws ShopException;
	// 获取网页授权信息
	GrandInfo getDynamicAccessoken(String code, WechatDevInfo devInfo) throws ShopException;
	// 设置模板消息所属行业
	void setIndustry(String accessToken) throws ShopException;
	// 获取模板id
	String getTemplateId(Integer type, String accessToken) throws ShopException;
	// 发送模板消息(返回0时，发送模板消息成功，-1时，为发送模板消息失败)
	Integer sendTemplateMessage(String openId, String templateId, ArrayList<String> paramList, 
			Class<? extends TemplateMessageData> messageData, String accessToKen, String url) throws ShopException;
	// 生成菜单(返回0时，生成菜单成功，非0时，为生成菜单失败)
	Integer generateMenu(String menu, String accessToken);
	// 获取参数二维码
	byte[] getWechatTwoDimensionalCode(String shopNo, String accessToken);
}
