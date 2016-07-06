package com.zjlp.face.shop.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.MessageContentDao;
import com.zjlp.face.shop.domain.MessageContent;
import com.zjlp.face.shop.mapper.MessageContentMapper;

@Repository("MessageContentDao")
public class MessageContentDaoImpl implements MessageContentDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<MessageContent> findByMessageBodyId(Long messageBodyId) {
		return sqlSession.getMapper(MessageContentMapper.class).
				selectListByMessageBodyId(messageBodyId);
	}

}
