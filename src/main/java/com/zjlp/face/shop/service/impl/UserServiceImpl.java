package com.zjlp.face.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.UserDao;
import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.UserDto;
import com.zjlp.face.shop.service.UserService;
import com.zjlp.face.shop.util.ConstantsUtil;
import com.zjlp.face.shop.util.Pagination;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void editUser(User user) {
		userDao.editUser(user);
	}

	@Override
	public Pagination<UserDto> findUserPageList(UserDto dto, Pagination<UserDto> pagination) {
		Integer totalRow = userDao.getCount(dto);
		List<UserDto> datas = userDao.findUserPageList(dto, pagination.getStart(), pagination.getPageSize());
		pagination.setTotalRow(totalRow);
		pagination.setDatas(datas);
		return pagination;
	}

	@Override
	public User getUserById(Long id) {
		return userDao.getUserById(id);
	}

	@Override
	public User getUserByLoginAccount(String loginAccount) {
		User user = new User();
		user.setLoginAccount(loginAccount);
		user.setStatus(ConstantsUtil.STATE_NORMAL);
		return userDao.getUser(user);
	}

}
