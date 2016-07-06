package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.Admin;

/**
 * 登录用户持久层
 * @ClassName: AdminDao 
 * @Description: (登录用户持久层) 
 * @author ah
 * @date 2014年7月16日 下午3:17:44
 */
public interface AdminDao {

	/**
	 * 根据登录名跟密码查询登陆用户
	 * @Title: getAdminByNameAndPasswd 
	 * @Description: (根据登录名跟密码查询登陆用户) 
	 * @param username
	 * @param password
	 * @return
	 * @date 2014年7月16日 下午3:19:07  
	 * @author ah
	 */
	Admin getAdminByNameAndPasswd(String username, String password);

}
