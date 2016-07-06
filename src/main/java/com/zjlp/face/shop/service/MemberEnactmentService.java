package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.MemberEnactment;

/**
 * 会员设定基础服务接口
 * @ClassName: MemberEnactmentService 
 * @Description: (会员设定基础服务接口) 
 * @author ah
 * @date 2014年7月25日 下午2:00:56
 */
public interface MemberEnactmentService {

	/**
	 * 新增会员设定
	 * @Title: addMemberEnactment 
	 * @Description: (新增会员设定) 
	 * @param memberEnactment
	 * @date 2014年7月25日 下午2:02:29  
	 * @author ah
	 */
	void addMemberEnactment(MemberEnactment memberEnactment);

	/**
	 * 根据用户id查询会员设置
	 * @Title: getByUserId 
	 * @Description: (根据用户id查询会员设置) 
	 * @param id
	 * @return
	 * @date 2014年8月1日 下午5:05:12  
	 * @author ah
	 */
	MemberEnactment getByUserId(Long id);

}
