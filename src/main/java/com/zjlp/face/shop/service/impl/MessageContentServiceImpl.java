package com.zjlp.face.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.MessageContentDao;
import com.zjlp.face.shop.domain.MessageContent;
import com.zjlp.face.shop.service.MessageContentService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MessageContentServiceImpl implements MessageContentService {
	
	@Autowired
	private MessageContentDao messageContentDao;

	@Override
	public List<MessageContent> findByMessageBodyId(Long messageBodyId) {
		return messageContentDao.findByMessageBodyId(messageBodyId);
	}

}
