package com.zjlp.face.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.MessageBodyDao;
import com.zjlp.face.shop.domain.MessageBody;
import com.zjlp.face.shop.service.MessageBodyService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MessageBodyServiceImpl implements MessageBodyService{
	
	@Autowired
	private MessageBodyDao messageBodyDao;

	@Override
	public MessageBody getMessageBodyById(Long messageBodyId) {
		return messageBodyDao.getMessageBodyById(messageBodyId);
	}

}
