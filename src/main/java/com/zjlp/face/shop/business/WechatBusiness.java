package com.zjlp.face.shop.business;

import java.util.Map;

/**
 * 微信接收消息、处理消息业务接口
 * @ClassName: wechatBusiness 
 * @Description: (微信接收消息、处理消息业务接口) 
 * @author ah
 * @date 2014年7月31日 下午8:48:13
 */
public interface WechatBusiness {

	/**
	 * 接收并推送消息
	 * @Title: processRequest 
	 * @Description: (接收并处理消息) 
	 * @param shopNo
	 * @param requestMap
	 * @return
	 * @date 2014年7月31日 下午8:52:53  
	 * @author ah
	 */
	String processRequest(String shopNo,Map<String, String> requestMap);

	/**
	 * 处理业务
	 * @Title: processRequestHandle
	 * @Description: (这里用一句话描述这个方法的作用)
	 * @param shopNo
	 * @param requestMap
	 * @return
	 * @return String
	 * @author phb
	 * @date 2015年5月18日 下午8:36:03
	 */
	String processRequestHandle(String shopNo,Map<String, String> requestMap);
}
