package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.Member;

/**
 * 会员基础服务接口
 * @ClassName: MemberService 
 * @Description: (会员基础服务接口) 
 * @author ah
 * @date 2014年7月25日 下午1:47:20
 */
public interface MemberService {

	/**
	 * 新增会员
	 * @Title: addMember 
	 * @Description: (新增会员) 
	 * @param member
	 * @date 2014年7月25日 下午1:48:31  
	 * @author ah
	 */
	void addMember(Member member);

}
