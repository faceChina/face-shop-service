package com.zjlp.face.shop.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.MemberDao;
import com.zjlp.face.shop.domain.Member;
import com.zjlp.face.shop.service.MemberService;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDao memberDao;

	@Override
	public void addMember(Member member) {
		memberDao.addMember(member);
	}

}
