package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.UserDto;
import com.zjlp.face.shop.util.Pagination;

/**
 * 用户基础服务接口
 * @ClassName: UserService 
 * @Description: (用户基础服务接口) 
 * @author ah
 * @date 2014年7月17日 下午2:23:57
 */
public interface UserService {

	/**
	 * 编辑用户
	 * @Title: editUser 
	 * @Description: (编辑用户) 
	 * @param user
	 * @date 2014年7月17日 下午2:44:46  
	 * @author ah
	 */
	void editUser(User user);

	/**
	 * 查询用户分页列表
	 * @Title: findUserPageList 
	 * @Description: (查询用户分页列表) 
	 * @param dto
	 * @param start
	 * @param pageSize
	 * @return
	 * @date 2014年7月17日 下午2:55:54  
	 * @author ah
	 */
	Pagination<UserDto> findUserPageList(UserDto dto, Pagination<UserDto> pagination);
	
	/**
	 * 根据ID查询用户
	 * @Title: getUserById 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param id
	 * @return
	 * @date 2014年7月17日 下午2:56:56  
	 * @author ah
	 */
	User getUserById(Long id);

	/**
	 * 根据登录名查询用户
	 * @Title: getUserByLoginAccount 
	 * @Description: (根据登录名查询用户) 
	 * @param loginAccount
	 * @return
	 * @date 2014年7月24日 下午7:30:17  
	 * @author ah
	 */
	User getUserByLoginAccount(String loginAccount);

}
