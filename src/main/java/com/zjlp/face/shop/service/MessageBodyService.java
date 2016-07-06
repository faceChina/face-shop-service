package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.MessageBody;

/**
 * 消息主体基础服务接口
 * @ClassName: MessageBodyService 
 * @Description: (消息主体基础服务接口) 
 * @author ah
 * @date 2014年8月1日 上午9:01:54
 */
public interface MessageBodyService {

	/**
	 * 根据主键查询消息主体
	 * @Title: getMessageBodyById 
	 * @Description: (根据主键查询消息主体) 
	 * @param messageBodyId
	 * @return
	 * @date 2014年8月1日 上午9:04:46  
	 * @author ah
	 */
	MessageBody getMessageBodyById(Long messageBodyId);

}
