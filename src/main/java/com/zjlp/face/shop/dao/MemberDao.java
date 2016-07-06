package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.Member;

/**
 * 会员持久层接口
 * @ClassName: MemberDao 
 * @Description: (会员持久层接口) 
 * @author ah
 * @date 2014年7月25日 下午1:55:46  
 */
public interface MemberDao {
	
	/**
	 * 新增会员
	 * @Title: addMember 
	 * @Description: (新增会员) 
	 * @param member
	 * @date 2014年7月25日 下午1:55:46  
	 * @author ah
	 */
	void addMember(Member member);
}
