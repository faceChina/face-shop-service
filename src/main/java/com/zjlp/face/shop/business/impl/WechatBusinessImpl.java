package com.zjlp.face.shop.business.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.time.StopWatch;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlp.face.shop.business.WechatBusiness;
import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.MessageBody;
import com.zjlp.face.shop.domain.MessageContent;
import com.zjlp.face.shop.domain.MessageSetting;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.TextMessage;
import com.zjlp.face.shop.domain.ToolSetting;
import com.zjlp.face.shop.domain.WechatUserInfo;
import com.zjlp.face.shop.domain.templatemessage.membershipCard.MembershipCardNotice;
import com.zjlp.face.shop.service.MessageBodyService;
import com.zjlp.face.shop.service.MessageContentService;
import com.zjlp.face.shop.service.MessageSettingService;
import com.zjlp.face.shop.service.ShopExternalService;
import com.zjlp.face.shop.service.ShopService;
import com.zjlp.face.shop.service.ToolSettingService;
import com.zjlp.face.shop.util.DateUtil;
import com.zjlp.face.shop.util.PropertiesUtil;
import com.zjlp.face.shop.util.enums.DateStyle;
import com.zjlp.face.shop.util.wechat.MD5;
import com.zjlp.face.shop.util.wechat.MessageUtil;
import com.zjlp.face.shop.util.wechat.WeiXinJzUtil;
import com.zjlp.face.web.server.operation.member.domain.MemberCard;
import com.zjlp.face.web.server.operation.member.service.MemberCardService;
import com.zjlp.face.web.server.user.weixin.domain.TemplateMessage;
import com.zjlp.face.web.server.user.weixin.service.TemplateMessageService;

@Service
public class WechatBusinessImpl implements WechatBusiness {
	
	@Autowired
	private ToolSettingService toolSettingService;
	@Autowired
	private MessageBodyService messageBodyService;
	@Autowired
	private MessageSettingService messageSettingService;
	@Autowired
	private MessageContentService messageContentService;
	@Autowired
	private ShopService shopService;
	@Autowired(required=false)
	private MemberCardService memberCardService;
	@Autowired
	private ShopExternalService shopExternalService;
	@Autowired(required=false)
	private TemplateMessageService templateMessageService;
	
	private Logger _replyInfoLog = Logger.getLogger("replyInfoLog");
	
	private Logger _replyErrorLog = Logger.getLogger("replyErrorLog");
	
	WeiXinJzUtil wt = new WeiXinJzUtil();
	
	@Override
	public String processRequest(String shopNo,Map<String, String> requestMap) {
		//回复内容
		String respMessage = null;
		//获取通讯方式设置
		ToolSetting tool = toolSettingService.getToolSettingByShopNo(shopNo);
		try {
			String respContent = "请求处理异常，请稍候尝试！";
			// xml请求解析
			// 发送方帐号（open_id）
			String toUserName = requestMap.get("FromUserName");
			// 公众帐号
			String fromUserName = requestMap.get("ToUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			// 消息内容
			String content = requestMap.get("Content");
			
			// 回复文本消息
			TextMessage textMessage = new TextMessage();
			textMessage.setToUserName(toUserName);
			textMessage.setFromUserName(fromUserName);
			textMessage.setCreateTime(new Date().getTime());
			textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
			// 事件推送
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");
				// 订阅
				_replyInfoLog.info("事件类型为："+eventType+"("+MessageUtil.getEventType(eventType)+")");
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					if (null==shopNo){
						return defaultReply("店铺还未上线, 尽请期待！",textMessage);
					}
					if(null==tool){
						return defaultReply("店铺还在建设中, 尽请期待！",textMessage);
					}
					// 确认关注是否回复
					if (isAttentionSwitchOpen(tool)) {
						_replyInfoLog.info("关注时回复已开启");
						String toContent = getMessageXML( shopNo,
								toUserName, fromUserName, 1, null,textMessage);
						if (null != toContent) {
							respMessage = toContent.toString();
						}else {
							respContent = "感谢您的关注！";
							respMessage =defaultReply(respContent,textMessage);
						}
					} else {
						respContent = "感谢您的关注！";
						respMessage =defaultReply(respContent,textMessage);
					}
					// 如果open_id是否存在，存在不管，不存在保存
				}
				// 取消订阅
				else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
					// 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
					respMessage = "1";
				}
				// 自定义菜单点击事件
				else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
					// 自定义菜单权没有开放，暂不处理该类消息
					respMessage = "1";
				}
			} else {
				boolean isKeywordRecovery = false;
				if (null==shopNo){
					return defaultReply("店铺还未上线, 尽请期待！",textMessage);
				}
				if(null==tool){
					return defaultReply("店铺还在建设中, 尽请期待！",textMessage);
				}
				if (iskeywordRecoverySwitchOpen(tool)) {// 关键字回复开关，如果有多条数据匹配，发update_time，create_time排序最新
					_replyInfoLog.info("关键字回复已开启");
					String toContent = getMessageXML( shopNo,
							toUserName, fromUserName, 3, content,textMessage);
					if (true!=toContent.equals("1")) {
						respMessage = toContent.toString();
						isKeywordRecovery = true;
					}
				}
				if (isReplySwitchOpen(tool) && !isKeywordRecovery) {// 消息回复开关，如果有多条数据匹配，发update_time，create_time排序最新
					_replyInfoLog.info("消息回复已开启");
					String toContent = getMessageXML( shopNo,
							toUserName, fromUserName, 2, null,textMessage);
					if (true!=toContent.equals("1")) {
						respMessage = toContent.toString();
					}else{
						return defaultReply("店铺还在建设中, 尽请期待！",textMessage);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(!"1".equals(respMessage)) {
			_replyInfoLog.info("回复消息内容："+respMessage);
		}
		return respMessage;
	}
	
	@Override
	public String processRequestHandle(String shopNo,Map<String, String> requestMap) {
		//获取产品编号
		try {
			// xml请求解析
			// 发送方帐号（open_id）
			String toUserName = requestMap.get("FromUserName");
			// 消息类型
			String msgType = requestMap.get("MsgType");
			
			// 事件推送
			if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
				String eventType = requestMap.get("Event");
				// 订阅
				_replyInfoLog.info("事件类型为："+eventType+"("+MessageUtil.getEventType(eventType)+")");
				if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
					Shop shop = shopService.getShopByShopNo(shopNo);
					if(0!=shop.getAuthenticate()) {
						String accessToken = "";
						try {
							// 获取accessToken
							_replyInfoLog.info("获取accessToken，店铺的appid为："+shop.getAppId()+"， appSecret:"+shop.getAppSecret());
							if(StringUtils.isNotBlank(shop.getAppId()) &&
								StringUtils.isNotBlank(shop.getAppSecret())	) {
								StopWatch clock = new StopWatch();
								clock.start(); // 计时开始
								accessToken = shopExternalService.getAccessToken(shop.getAppId(),shop.getAppSecret());
								clock.stop();
								_replyInfoLog.info("=====严重警告！！！该方法getAccessToken执行耗费:" + clock.getTime() + " ms ");
							} else {
								_replyErrorLog.error("获取accessToken失败,店铺的appid为："+shop.getAppId()+"， appSecret:"+shop.getAppSecret());
							}
						} catch (Exception e) {
							_replyErrorLog.error("获取accessToken失败,店铺的appid为："+shop.getAppId()+"， appSecret:"+shop.getAppSecret(), e);
						}
						StopWatch clock4 = new StopWatch();
						clock4.start(); // 计时开始
						WechatUserInfo wechatUserInfo = this._getWechatUserInfo(shop, toUserName, accessToken);
						clock4.stop();
						_replyInfoLog.info("=====严重警告！！！该方法_getWechatUserInfo执行耗费:" + clock4.getTime() + " ms ");
						
						StopWatch clock5 = new StopWatch();
						clock5.start();
						String fakeId = this._getFakeId(wechatUserInfo,shop, toUserName, accessToken);
						clock5.stop();
						_replyInfoLog.info("======严重警告！！！该方法_getFakeId执行耗费:" + clock5.getTime() + " ms ");
						
						StopWatch clock3 = new StopWatch();
			    		clock3.start(); // 计时开始
						// 新增会员卡
						this.addMemberCard(shop, toUserName, fakeId, accessToken);
						clock3.stop();
						_replyInfoLog.info("=====严重警告！！！该方法addMemberCard执行耗费:" + clock3.getTime() + " ms ");
						
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	
	// 新增会员卡
	public void addMemberCard(Shop shop, String openid, String fakeId, String accessToKen) {
		if(null != shop && StringUtils.isNotBlank(fakeId)) {
			try {
				// 根据店铺编号查询店铺
				if(null != shop.getUserId() &&
					StringUtils.isNotBlank(openid) &&
					StringUtils.isNotBlank(fakeId)) {
					MemberCard oldMemberCard = new MemberCard();
					oldMemberCard.setSellerId(shop.getUserId());
					oldMemberCard.setFakeId(fakeId);
					oldMemberCard = memberCardService.getMemberCard(oldMemberCard);
					// 新增会员卡
					MemberCard memberCard = memberCardService.generateMemberCard(openid, shop.getUserId(), fakeId, shop.getNo());
					if(null == oldMemberCard && null != memberCard) {
						// 查询模板消息
						TemplateMessage templateMessage = new TemplateMessage();
						templateMessage.setShopNo(shop.getNo());
						templateMessage.setType(1);
						templateMessage = templateMessageService.getTemplateMessage(templateMessage);
						if(null != templateMessage && StringUtils.isNotBlank(templateMessage.getTemplateId())) {
							// 发送模板消息
							ArrayList<String> paramList = new ArrayList<String>();
							paramList.add("您好，您的会员卡已成功领取。");
							paramList.add(memberCard.getMemberCard());
							paramList.add(memberCard.getUserName());
							paramList.add(memberCard.getCell());
							paramList.add(DateUtil.DateToString(memberCard.getCreateTime(), DateStyle.YYYY_MM_DD_HH_MM_CN));
							paramList.add("感谢您的使用 , 祝您生活愉快！");
							shopExternalService.sendTemplateMessage(openid, templateMessage.getTemplateId(), paramList, MembershipCardNotice.class, accessToKen, null);
						}
					}
				} else {
					_replyErrorLog.error("新增会员卡失败：openid = "+openid+" ,adminId= "+shop.getUserId()+", fakeId="+fakeId);
				}
			} catch (Exception e) {
				_replyErrorLog.error("新增会员卡失败：openid = "+openid+" ,adminId= "+shop.getUserId()+", fakeId="+fakeId, e);
			}
		}
	}
	
	
	private WechatUserInfo _getWechatUserInfo(Shop shop, String openid, String accessToken){
		WechatUserInfo wechatUserInfo = new WechatUserInfo();
		try {
			// 获取用户信息
			_replyInfoLog.info("新增名片时，获取微信用户信息，用户的openid为："+openid+"， accessToken:"+accessToken);
			GrandInfo grandInfo = new GrandInfo();
			grandInfo.setOpenId(openid);
			grandInfo.setAccessToken(accessToken);
			wechatUserInfo = wt.getWechatUserUnionIDInfo(grandInfo);
		} catch (Exception e) {
			_replyErrorLog.error("新增名片时，获取微信用户信息失败，用户的openid为："+openid+"， accessToken:"+accessToken, e);
		}
		return wechatUserInfo;
	}
	
	private String _getFakeId(WechatUserInfo wechatUserInfo,Shop shop, String openid, String accessToken){
		String fakeId = "";
		try {
			// 获取微信用户对应的fakeid
			if(StringUtils.isNotBlank(wechatUserInfo.getNickname())) {
				_replyInfoLog.info("新增名片时，获取微信用户对应的fakeid，用户的昵称为："+wechatUserInfo.getNickname()+
						"， openid:"+openid+"，wechat:"+shop.getWechat()+", Passwd:"+shop.getPasswd());
				StopWatch clock = new StopWatch();
				clock.start(); // 计时开始
				wt.login(shop.getWechat(), MD5.getMd5(shop.getPasswd(), "utf-8"));
				clock.stop();
				_replyInfoLog.info("======严重警告！！！该方法wt.login执行耗费:" + clock.getTime() + " ms ");
				
				StopWatch clock1 = new StopWatch();
				clock1.start(); // 计时开始
				fakeId = wt.getFakeid(wechatUserInfo.getNickname(), openid);
				clock1.stop();
				_replyInfoLog.info("======严重警告！！！该方法wt.getFakeid执行耗费:" + clock1.getTime() + " ms ");
			} else {
				_replyInfoLog.info("新增名片时，获取微信用户对应的fakeid失败，用户的昵称为："+wechatUserInfo.getNickname()+"， openid:"+openid);
			}
		} catch (Exception e) {
			_replyErrorLog.error("新增名片时，获取微信用户对应的fakeid失败，用户的昵称为："+wechatUserInfo.getNickname()+"， openid:"+openid, e);
		}
		return fakeId;
	}
	
	public String getMessageXML( String shopNo,String toUserName, String fromUserName, Integer eventType,
			String keyWord,TextMessage textMessage) {
		//请求地址
		String realPath = PropertiesUtil.getConfig("jzwgjURL");
		_replyInfoLog.info("请求地址："+realPath);
		//图片地址
		String picUrl = PropertiesUtil.getConfig("picURL");
		_replyInfoLog.info("图片地址："+picUrl);
		
		//查询消息设置
		MessageSetting messageSetting = getMessageSetting(shopNo, eventType,
				keyWord);
		String Message = null;
		if (null != messageSetting) {
			//查询消息主体
			MessageBody messageBody = messageBodyService.getMessageBodyById(messageSetting
					.getMessageBodyId());
			if (null != messageBody) {
				StringBuffer toContent = new StringBuffer();
				String replaceFromUserName = "$FromUserName$";
				String replaceToUserName = "$ToUserName$";
				String replaceUrlPath = "$jzwgj$";
				String replacePicUrlPath = "$picUrl$";
				String messageContentId = "$MessageContentId$";
				toContent.append(messageBody.getMessageContent());
				_replyInfoLog.info("消息主体id="+messageBody.getId());
				_replyInfoLog.info("回复消息类型 type="+messageBody.getType()+"("+getMessageType(messageBody.getType())+")");
				// FromUserName替换
				int indexOfFromUserName = toContent
						.indexOf(replaceFromUserName);
				if (indexOfFromUserName != -1) {
					toContent.replace(indexOfFromUserName, indexOfFromUserName
							+ replaceFromUserName.length(), fromUserName);
				}
	
				// ToUserName替换
				int indexOfToUserName = toContent.indexOf(replaceToUserName);
	
				if (indexOfToUserName != -1) {
					toContent.replace(indexOfToUserName, indexOfToUserName
							+ replaceToUserName.length(), toUserName);
				}
				
				// path替换
				int indexOfUrlPath = toContent.indexOf(replaceUrlPath);
				for (int i = 0; i < toContent.length();) {
					if (-1 == indexOfUrlPath) {
						break;
					}
					toContent.replace(indexOfUrlPath, indexOfUrlPath
							+ replaceUrlPath.length(), realPath);
					i = indexOfUrlPath = toContent.indexOf(replaceUrlPath);
				}
				// 图片地址替换
				int indexOfPicUrlPath = toContent.indexOf(replacePicUrlPath);
				for (int i = 0; i < toContent.length();) {
					if (-1 == indexOfPicUrlPath) {
						break;
					}
					toContent.replace(indexOfPicUrlPath, indexOfPicUrlPath
							+ replacePicUrlPath.length(), picUrl);
					i = indexOfPicUrlPath = toContent.indexOf(replacePicUrlPath);
				}
				// messageContentId替换
				int indexOfContentId = toContent.indexOf(messageContentId);
				if(-1 != indexOfContentId) {
					List<MessageContent> mContents = messageContentService.
							findByMessageBodyId(messageSetting.getMessageBodyId());
					for (int i = 0; i < mContents.size(); i++) {
						Integer start = indexOfContentId+ messageContentId.length();
						Integer end = start+1;
						Integer sort = Integer.valueOf(toContent.substring(start, end));
						if(i==sort) {
							toContent.replace(start, end, "");
							toContent.replace(indexOfContentId, start, mContents.get(i).getId().toString());
						}
						indexOfContentId = toContent.indexOf(messageContentId);
						if(-1 == indexOfContentId) {
							break;
						}
					}
				}
				Message = toContent.toString();
			}else{
				return "1";
			}
		}else{
			return "1";
		}
		return Message;
	}
	
	//获取消息类型
	private String getMessageType(Integer type) {
		String mtype = "";
		//消息类型 1：关注时回复 2：消息时回复 3：关键词回复
		if(1==type) {
			mtype = "关注时回复";
		}else if(2==type) {
			mtype = "消息时回复";
		}else if(3==type) {
			mtype = "关键词回复";
		}else {
			mtype = "未知消息类型";
		}
		return mtype;
	}

	//查询消息设置
	public MessageSetting getMessageSetting(String shopNo, Integer eventType,
			String keyWord) {
		MessageSetting messageSetting = new MessageSetting();
		messageSetting.setShopNo(shopNo);
		messageSetting.setEventType(eventType);
		messageSetting.setKeyWord(keyWord);
		return messageSettingService.getMessageSettingByShopNo(messageSetting);
	}

	//判断关注时回复是否开启
	public boolean isAttentionSwitchOpen(ToolSetting tool) {
		return tool.getAttentionSwitch() == 1 ? true : false;
	}
	////判断关键词时回复是否开启
	public boolean iskeywordRecoverySwitchOpen(ToolSetting tool) {
		return tool.getKeywordRecoverySwitch() == 1 ? true : false;
	}
	//判断消息时回复是否开启
	public boolean isReplySwitchOpen(ToolSetting tool) {
		return tool.getReplySwitch() == 1 ? true : false;
	}
	
	//回复默认消息时用
	public String defaultReply(String respContent,TextMessage textMessage){
		textMessage.setContent(respContent);
		String respMessage = MessageUtil.textMessageToXml(textMessage);
		return respMessage;
	} 
}
