package com.zjlp.face.shop.mapper;

import java.util.List;

import com.zjlp.face.shop.domain.MessageContent;

public interface MessageContentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageContent record);

    int insertSelective(MessageContent record);

    MessageContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageContent record);

    int updateByPrimaryKey(MessageContent record);

	List<MessageContent> selectListByMessageBodyId(Long messageBodyId);
}