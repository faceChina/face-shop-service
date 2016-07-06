package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.MessageBody;

/**
 * 消息主体持久层
 * @ClassName: MessageBodyDao 
 * @Description: (消息主体持久层) 
 * @author Administrator
 * @date 2014年8月1日 上午9:44:57
 */
public interface MessageBodyDao {

	/**
	 * 根据主键查询消息主体
	 * @Title: getMessageBodyById 
	 * @Description: (根据主键查询消息主体) 
	 * @param messageBodyId
	 * @return
	 * @date 2014年8月1日 上午9:45:32  
	 * @author ah
	 */
	MessageBody getMessageBodyById(Long messageBodyId);

}
