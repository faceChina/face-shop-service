package com.zjlp.face.shop.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.ToolSettingDao;
import com.zjlp.face.shop.domain.ToolSetting;
import com.zjlp.face.shop.mapper.ToolSettingMapper;

@Repository("ToolSettingDao")
public class ToolSettingDaoImpl implements ToolSettingDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void addToolSetting(ToolSetting toolSetting) {
		sqlSession.getMapper(ToolSettingMapper.class).insertSelective(toolSetting);

	}

	@Override
	public ToolSetting getToolSettingByShopNo(String shopNo) {
		return sqlSession.getMapper(ToolSettingMapper.class).selectByShopNo(shopNo);
	}

}
