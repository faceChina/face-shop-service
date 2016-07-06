package com.zjlp.face.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.UserDao;
import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.UserDto;
import com.zjlp.face.shop.mapper.UserMapper;

@Repository("UserDao")
public class UserDaoImpl implements UserDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void editUser(User user) {
		sqlSession.getMapper(UserMapper.class).updateByPrimaryKeySelective(user);
	}

	@Override
	public List<UserDto> findUserPageList(UserDto dto, int start, int pageSize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("dto", dto);
		map.put("start", start);
		map.put("pageSize", pageSize);
		return sqlSession.getMapper(UserMapper.class).selectList(map);
	}

	@Override
	public Integer getCount(UserDto dto) {
		return sqlSession.getMapper(UserMapper.class).getCount(dto);
	}

	@Override
	public User getUserById(Long id) {
		return sqlSession.getMapper(UserMapper.class).selectByPrimaryKey(id);
	}

	@Override
	public User getUser(User user) {
		return sqlSession.getMapper(UserMapper.class).getUser(user);
	}

}
