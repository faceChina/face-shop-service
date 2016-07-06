package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.MessageBodyDao;
import com.zjlp.face.shop.domain.MessageBody;
import com.zjlp.face.shop.mapper.MessageBodyMapper;

@Repository("MessageBodyDao")
public class MessageBodyDaoImpl implements MessageBodyDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MessageBody getMessageBodyById(Long messageBodyId) {
		return sqlSession.getMapper(MessageBodyMapper.class).selectByPrimaryKey(messageBodyId);
	}

}
