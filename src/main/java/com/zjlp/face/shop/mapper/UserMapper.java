package com.zjlp.face.shop.mapper;

import java.util.List;
import java.util.Map;

import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.UserDto;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

	List<UserDto> selectList(Map<String, Object> map);

	Integer getCount(UserDto dto);

	User getUser(User user);
}