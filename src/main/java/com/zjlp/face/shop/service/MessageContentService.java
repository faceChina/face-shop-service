package com.zjlp.face.shop.service;

import java.util.List;

import com.zjlp.face.shop.domain.MessageContent;

/**
 * 消息内容基础服务接口
 * @ClassName: MessageContentService 
 * @Description: (消息内容基础服务接口) 
 * @author ah
 * @date 2014年8月8日 下午1:45:26
 */
public interface MessageContentService {

	/**
	 * 根据消息主体id查询消息内容
	 * @Title: findByMessageBodyId 
	 * @Description: (根据消息主体id查询消息内容) 
	 * @param messageBodyId
	 * @return
	 * @date 2014年8月8日 下午1:47:14  
	 * @author ah
	 */
	List<MessageContent> findByMessageBodyId(Long messageBodyId);

}
