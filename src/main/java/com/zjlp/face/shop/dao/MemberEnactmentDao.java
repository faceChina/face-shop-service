package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.MemberEnactment;

/**
 * 会员设定持久层
 * @ClassName: MemberEnactmentDao 
 * @Description: (会员设定持久层) 
 * @author ah
 * @date 2014年7月25日 下午2:04:53
 */
public interface MemberEnactmentDao {

	/**
	 * 新增会员设置
	 * @Title: addMemberEnactment 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param memberEnactment
	 * @date 2014年7月25日 下午2:04:57 
	 * @author ah
	 */
	void addMemberEnactment(MemberEnactment memberEnactment);

	/**
	 * 根据用户id查询会员设置
	 * @Title: getByUserId 
	 * @Description: (根据用户id查询会员设置) 
	 * @param id
	 * @return
	 * @date 2014年8月1日 下午5:06:37  
	 * @author Administrator
	 */
	MemberEnactment getByUserId(Long id);
}
