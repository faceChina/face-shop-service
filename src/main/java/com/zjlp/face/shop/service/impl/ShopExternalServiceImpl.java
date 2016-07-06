package com.zjlp.face.shop.service.impl;

import java.util.ArrayList;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlp.face.shop.domain.AccessToken;
import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.WechatDevInfo;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;
import com.zjlp.face.shop.factory.ShopFactory;
import com.zjlp.face.shop.service.ShopExternalService;
import com.zjlp.face.shop.service.WechatService;
import com.zjlp.face.shop.util.wechat.WeiXinJzUtil;

@Service("shopExternalService")
public class ShopExternalServiceImpl implements ShopExternalService{
	
	private Logger _logger = Logger.getLogger(ShopExternalServiceImpl.class);
	
	private static final String ACCESS_TOKEN_KEY = "WEIXIN_getAccessToken_";
	
	@Autowired
	private ShopFactory commonShopFactory;
	
	@Autowired
	private ShopFactory smallShopFactory;
	
	@Autowired
	private WechatService wechatService;
	
	private ShopFactory freeShopFactory;
	
	@Override
	public Shop addSmallShop(ShopDto dto) throws ShopException {
		// 新增微小店
		return smallShopFactory.addShop(dto);
	}

	@Override
	public Shop addCommonShop(ShopDto dto) throws ShopException {
		// 新增普通店铺
		return commonShopFactory.addShop(dto);
	}

	@Override
	public void bindShop(ShopDto dto) throws ShopException {
		// 对店铺绑定微信号
		wechatService.bindShop(dto);
		
	}

	@Override
	public Shop addFreeShop(ShopDto dto) throws ShopException {
		// 新增免费店铺
		return freeShopFactory.addShop(dto);
	}
	
	@Override
	public GrandInfo getDynamicAccessoken(String code, WechatDevInfo devInfo)
			throws ShopException {
		// 获取网页授权信息
		return wechatService.getDynamicAccessoken(code, devInfo);
	}

	
	@Override
	public String getAccessToken(String appId, String appSecret)
			throws ShopException {
		String token = null;
//		StringBuffer keyBuffer = new StringBuffer();
		try {
			// 从缓存中拿数据
//			String accessTokenKey = keyBuffer.append(ACCESS_TOKEN_KEY).append(appId).append(appSecret).toString();
//			StringRedisHelper helper = RedisClusterClient.getStringClient();
//			if(null != helper){
//				// 从缓存中拿数据
//				token = helper.get(accessTokenKey);
//				_logger.info("从缓存中获取TOKEN="+token);
//				// 缓存中数据为空时，查询数据并保存到缓存
//				if(StringUtils.isNotBlank(token)) {
//					// 向微信端请求获取accessToken
//					AccessToken accessToken = new WeiXinJzUtil().getAccessToken(appId, appSecret);
//					helper.set(accessTokenKey, accessToken.getToken());
//				}
//			} else {
//				// 向微信端请求获取accessToken
//				AccessToken accessToken = new WeiXinJzUtil().getAccessToken(appId, appSecret);
//				token = accessToken.getToken();
//			}
			if(null == token ) {
				// 向微信端请求获取accessToken
				AccessToken accessToken = new WeiXinJzUtil().getAccessToken(appId, appSecret);
				token = accessToken.getToken();
			}
			_logger.info("返回TOKEN="+token);
		} catch (Exception e) {
			throw new ShopException("获取AccessToken异常",e);
		}
		return token;
	}

	@Override
	public String getAccessTokenFromWechat(String appId, String appSecret)
			throws ShopException {
		String token = null;
//		StringBuffer keyBuffer = new StringBuffer();
		try {
			// 从缓存中拿数据
//			String accessTokenKey = keyBuffer.append(ACCESS_TOKEN_KEY).append(appId).append(appSecret).toString();
//			StringRedisHelper helper = RedisClusterClient.getStringClient();
			//从微信端直接获取accessToken,设置到缓存
			if(StringUtils.isBlank(token)){
				AccessToken accessToken = new WeiXinJzUtil().getAccessToken(appId, appSecret);
				token = accessToken.getToken();
				_logger.info("请求获取TOKEN="+token);
//				if(null != helper){
//					helper.set(accessTokenKey, token);
//				}
				
			}
			_logger.info("返回TOKEN="+token);
		} catch (Exception e) {
			throw new ShopException("获取AccessToken异常",e);
		}
		return token;
	}

	@Override
	public void setIndustry(String accessToken) throws ShopException {
		// 设置模板消息所属行业
		wechatService.setIndustry(accessToken);
		
	}

	@Override
	public String getTemplateId(Integer type, String accessToken)
			throws ShopException {
		// 获取模板消息id(返回结果为null时，获取模板消息id失败)
		return wechatService.getTemplateId(type, accessToken);
	}

	@Override
	public Integer sendTemplateMessage(String openId, String templateId,
			ArrayList<String> paramList,
			Class<? extends TemplateMessageData> messageData,
			String accessToKen, String url) throws ShopException {
		// 发送模板消息(返回0时，发送模板消息成功，-1时，为发送模板消息失败)
		return wechatService.sendTemplateMessage(openId, templateId, paramList, messageData, accessToKen, url);
	}

	@Override
	public Integer generateMenu(String menu, String accessToken) throws ShopException{
		// 生成自定义菜单
		return wechatService.generateMenu(menu, accessToken);
	}

	@Override
	public byte[] getWechatTwoDimensionalCode(String shopNo, String accessToken) {
		// 创建二维码
		WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
		String ticket = weiXinJzUtil.createTwoDimensionalCode(shopNo, accessToken);
		if(StringUtils.isNotBlank(ticket)) {
			try {
				_logger.info("获取微信带参数二维码开始，ticket："+ticket);
				byte[] twoDimensionalCode = weiXinJzUtil.getTwoDimensionalCode(ticket);
				_logger.info("获取微信带参数二维码结束");
				return twoDimensionalCode;
			} catch (Exception e) {
				_logger.error("获取微信带参数二维码开始，ticket："+ticket, e);
			}
		}
		return null;
	}

}
