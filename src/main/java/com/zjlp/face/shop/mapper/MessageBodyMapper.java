package com.zjlp.face.shop.mapper;

import com.zjlp.face.shop.domain.MessageBody;

public interface MessageBodyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(MessageBody record);

    int insertSelective(MessageBody record);

    MessageBody selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(MessageBody record);

    int updateByPrimaryKeyWithBLOBs(MessageBody record);

    int updateByPrimaryKey(MessageBody record);
    
    MessageBody slectById(Long id);
}