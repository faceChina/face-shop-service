package com.zjlp.face.shop.service.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlp.face.shop.domain.AccessToken;
import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.WechatDevInfo;
import com.zjlp.face.shop.domain.templatemessage.DataValue;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessage;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;
import com.zjlp.face.shop.exception.enums.ShopExceptionEnum;
import com.zjlp.face.shop.service.ShopExternalService;
import com.zjlp.face.shop.service.ShopService;
import com.zjlp.face.shop.service.WechatService;
import com.zjlp.face.shop.util.AssertUtil;
import com.zjlp.face.shop.util.PropertiesUtil;
import com.zjlp.face.shop.util.wechat.MD5;
import com.zjlp.face.shop.util.wechat.WeiXinJzUtil;

@Service("wechatService")
public class WechatServiceImpl implements WechatService {

	@Autowired
    private ShopService shopService;
	
	@Autowired
	private ShopExternalService shopExternalService;
	
	// 微信url
    private String URL = PropertiesUtil.getConfig("webURL");
    // 开发模式2 编辑模式1
    private String TYPE = "2";
    // 开启1关闭0
    private String FLG = "1";
    // 返回结果
    private Integer SUCCESS_CODE = 0;
    
    private Logger _wechatInfoLog = Logger.getLogger("wechatInfoLog");
    
    // 微信token
    private static String TOKEN = "python5915";
	@Override
	public void bindShop(ShopDto dto) throws ShopException {
		try{
            // 微信号绑定判断
            Shop shop = shopService.getShopByWechat(dto.getWechat(), dto.getNo());
            if(null != shop){
                AssertUtil.isTrue(null != shop, ShopException.class, ShopExceptionEnum.SHOP_90001);
            }
            // 开发者url
            dto.setUrl(URL + "/wgjbiz/weixin/" + dto.getNo() + "/attention.html");
            Date time = new Date();
            shop = new Shop();
            shop.setNo(dto.getNo());
            shop.setWechat(dto.getWechat());
            shop.setPasswd(dto.getPasswd());
            shop.setUpdateTime(time);
            shop.setBindingTime(time);
            WeiXinJzUtil wt = new WeiXinJzUtil();
            // 登陆微信（假登陆）
            _wechatInfoLog.info("开发者url="+dto.getUrl());
            Integer ret = wt.login(shop.getWechat(), MD5.getMd5(shop.getPasswd(), "utf-8"));
            AssertUtil.isTrue(!(ret== 0), ShopException.class, ShopException.ErrorMsg(ret));
            // 开启开发者模式
            ret = wt.setMode(TYPE, FLG);
            if(ret != 0) {
            	_wechatInfoLog.info("微信公众平台端，开启开发者模式失败!");
            }
            // 绑定产品设置微信url
            ret = wt.setURL(dto.getUrl(), TOKEN);
            AssertUtil.isTrue(!(ret== 0), ShopException.class, ShopException.ErrorMsg(ret));
            // 绑定微信号
            shopService.editShop(shop);
        }catch(ShopException e){
            throw e;
        }catch(Exception e){
            throw new ShopException(e);
        }

	}
	
	@Override
	public Integer sendTemplateMessage(String openId, String templateId, ArrayList<String> paramList, 
			Class<? extends TemplateMessageData> messageData, String accessToKen, String url) throws ShopException {
		try {
			WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
			// 发送模板消息
			TemplateMessageData result = messageData.newInstance();
			int fieldLength = messageData.getDeclaredFields().length;
			for (int i = 0; i < fieldLength; i++) {
				String mName = messageData.getDeclaredFields()[i].getName();
				StringBuffer methodName = new StringBuffer();
				methodName = methodName.append("set").append(mName.substring(0, 1).toUpperCase()).append(mName.substring(1));
				Method method = messageData.getMethod(methodName.toString(), new Class[] { DataValue.class });
				if(method != null) {
					DataValue dataValue = new DataValue();
					dataValue.setValue(paramList.get(i));
					//调用设置的方法，给属性赋值
					method.invoke(result, dataValue);
				}
			}
			TemplateMessage templateMessage = new TemplateMessage();
			templateMessage.setTouser(openId);
			templateMessage.setTemplate_id(templateId);
			templateMessage.setUrl(url);
			templateMessage.setData(result);
			// 发送模板消息
			Integer ret = weiXinJzUtil.sendTemplateMessage(templateMessage, accessToKen);
			return ret;
		} catch (Exception e) {
			throw new ShopException(e);
		}
		
	}

	@Override
	public void checkDeveleperInfo(String appId, String appSecret)
			throws ShopException {
		try {
			_wechatInfoLog.info("验证开发者信息开始"+"appId="+appId+",appSecret="+appSecret);
			// 尝试获取accessToken,如果开发者信息不对则抛出异常
			shopExternalService.getAccessTokenFromWechat(appId, appSecret);
			AccessToken accessToken = new WeiXinJzUtil().getAccessToken(appId, appSecret);
			// 获取accessToken时失败，抛出异常
			if(StringUtils.isNotBlank(accessToken.getErrcode())) {
				AssertUtil.isTrue(StringUtils.isNotBlank(accessToken.getErrcode()), ShopException.class,
						ShopException.ErrorMsg(Integer.valueOf(accessToken.getErrcode())));
			}
			_wechatInfoLog.info("验证开发者信息结束");
		} catch (Exception e) {
			throw new ShopException("获取AccessToken异常",e);
		}
	}

	@Override
	public GrandInfo getDynamicAccessoken(String code, WechatDevInfo devInfo) {
		
		try {
			_wechatInfoLog.info("获取网页授权信息开始"+"code="+code+",appappId="+devInfo.getAppId()+",appSecret="+devInfo.getAppSecret());
			WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
			// 获取网页授权信息
			GrandInfo grandInfo = weiXinJzUtil.getDynamicAccessoken(code, devInfo);
			_wechatInfoLog.info("获取网页授权信息结束");
			return grandInfo;
		} catch (Exception e) {
			throw new ShopException("获取网页授权信息异常",e);
		}
	}

	@Override
	public void setIndustry(String accessToken) throws ShopException{
		try {
			AssertUtil.notNull(accessToken, "参数accessToken为空");
			WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
			// 设置模板消息所属行业
			Integer result = weiXinJzUtil.setIndustry(accessToken);
			AssertUtil.isTrue(SUCCESS_CODE.equals(result), ShopException.class,
					ShopExceptionEnum.SHOP_90011);
		} catch (Exception e) {
			throw new ShopException("设置模板消息所属行业失败",e);
		}
	}

	@Override
	public String getTemplateId(Integer type, String accessToken) throws ShopException {
		try {
			AssertUtil.notNull(accessToken, "参数accessToken为空");
			WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
			// 获得模板ID
			String templateId = weiXinJzUtil.getTemplateId(weiXinJzUtil._getTemplateNo(type), accessToken);
			return templateId;
		} catch (Exception e) {
			throw new ShopException("获取模板id失败", e);
		}
	}

	@Override
	public Integer generateMenu(String menu, String accessToken)
			throws ShopException {
		try {
			WeiXinJzUtil weiXinJzUtil = new WeiXinJzUtil();
			// 生成自定义菜单
			Integer ret = weiXinJzUtil.createMenu(menu, accessToken);
			return ret;
		} catch (Exception e) {
			throw new ShopException("生成自定义菜单失败", e);
		}
	}
	
}
