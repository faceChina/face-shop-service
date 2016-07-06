package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.MessageSettingDao;
import com.zjlp.face.shop.domain.MessageSetting;
import com.zjlp.face.shop.mapper.MessageSettingMapper;

@Repository("MessageSettingDao")
public class MessageSettingDaoImpl implements MessageSettingDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public MessageSetting getMessageSettingByShopNo(
			MessageSetting messageSetting) {
		return sqlSession.getMapper(MessageSettingMapper.class).selectByShopNo(messageSetting);
	}

}
