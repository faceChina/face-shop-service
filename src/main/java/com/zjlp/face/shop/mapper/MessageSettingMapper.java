package com.zjlp.face.shop.mapper;

import java.util.List;
import java.util.Map;

import com.zjlp.face.shop.domain.MessageSetting;

public interface MessageSettingMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageSetting record);

    int insertSelective(MessageSetting record);

    MessageSetting selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageSetting record);

    int updateByPrimaryKey(MessageSetting record);
    
    List<MessageSetting> listMessageSetByShopNO(String shopNo);
	
	List<MessageSetting> searchMessageSetByKeyWord(Map<String,String> map);
	
	MessageSetting selectByShopNo(MessageSetting messagesetting);
}