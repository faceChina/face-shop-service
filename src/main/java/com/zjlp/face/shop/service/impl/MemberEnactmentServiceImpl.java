package com.zjlp.face.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.MemberEnactmentDao;
import com.zjlp.face.shop.domain.MemberEnactment;
import com.zjlp.face.shop.service.MemberEnactmentService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MemberEnactmentServiceImpl implements MemberEnactmentService {
	
	@Autowired
	private MemberEnactmentDao memberEnactmentDao;
	
	@Override
	public void addMemberEnactment(MemberEnactment memberEnactment) {
		memberEnactmentDao.addMemberEnactment(memberEnactment);

	}

	@Override
	public MemberEnactment getByUserId(Long id) {
		return memberEnactmentDao.getByUserId(id);
	}

}
