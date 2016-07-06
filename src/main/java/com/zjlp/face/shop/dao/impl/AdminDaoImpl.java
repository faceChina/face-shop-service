package com.zjlp.face.shop.dao.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.AdminDao;
import com.zjlp.face.shop.domain.Admin;
import com.zjlp.face.shop.mapper.AdminMapper;

@Repository("AdminDao")
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public Admin getAdminByNameAndPasswd(String username, String passwd){
		
		Map<String,String> map = new HashMap<String,String>();
		map.put("username", username);
		map.put("passwd", passwd);
		return sqlSession.getMapper(AdminMapper.class).getAdminByNameAndPasswd(map);
		
	}

}
