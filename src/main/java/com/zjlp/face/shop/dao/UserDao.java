package com.zjlp.face.shop.dao;

import java.util.List;

import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.UserDto;

/**
 * 用户持久层
 * @ClassName: UserDao 
 * @Description: (用户持久层) 
 * @author ah
 * @date 2014年7月17日 下午3:03:08
 */
public interface UserDao {

	/**
	 * 编辑用户
	 * @Title: editUser 
	 * @Description: (编辑用户) 
	 * @param user
	 * @date 2014年7月17日 下午3:04:33  
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
	 * @date 2014年7月17日 下午3:20:09  
	 * @author ah
	 */
	List<UserDto> findUserPageList(UserDto dto, int start, int pageSize);

	/**
	 * 查询用户总数
	 * @Title: getCount 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param dto
	 * @return
	 * @date 2014年7月17日 下午3:20:46  
	 * @author ah
	 */
	Integer getCount(UserDto dto);

	/**
	 * 根据id查询用户
	 * @Title: getUserById 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param id
	 * @return
	 * @date 2014年7月17日 下午3:21:28  
	 * @author ah
	 */
	User getUserById(Long id);

	/**
	 * 查询用户
	 * @Title: getUser 
	 * @Description: (查询用户) 
	 * @param user
	 * @return
	 * @date 2014年7月24日 下午7:35:30  
	 * @author ah
	 */
	User getUser(User user);

}
