package com.zjlp.face.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.MessageSettingDao;
import com.zjlp.face.shop.domain.MessageSetting;
import com.zjlp.face.shop.service.MessageSettingService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MessageSettingServiceImpl implements MessageSettingService {
	
	@Autowired
	private MessageSettingDao messageSettingDao;

	@Override
	public MessageSetting getMessageSettingByShopNo(MessageSetting messageSetting) {
		return messageSettingDao.getMessageSettingByShopNo(messageSetting);
	}

}
