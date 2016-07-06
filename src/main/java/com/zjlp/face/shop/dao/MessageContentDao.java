package com.zjlp.face.shop.dao;

import java.util.List;

import com.zjlp.face.shop.domain.MessageContent;

/**
 * 消息内容持久层
 * @ClassName: MessageContentDao 
 * @Description: (消息内容持久层) 
 * @author ah
 * @date 2014年8月8日 下午1:51:20
 */
public interface MessageContentDao {

	/**
	 * 根据消息主体id查询消息内容
	 * @Title: findByMessageBodyId 
	 * @Description: (根据消息主体id查询消息内容) 
	 * @param messageBodyId
	 * @return
	 * @date 2014年8月8日 下午1:51:52  
	 * @author ah
	 */
	List<MessageContent> findByMessageBodyId(Long messageBodyId);

}
