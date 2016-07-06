package com.zjlp.face.shop.dao;

import com.zjlp.face.shop.domain.ToolSetting;

/**
 * 通讯方式设置持久层
 * @ClassName: ToolSettingDao 
 * @Description: (通讯方式设置持久层) 
 * @author ah
 * @date 2014年7月25日 下午2:24:10
 */
public interface ToolSettingDao {

	/**
	 * 新增通讯方式设置
	 * @Title: addToolSetting 
	 * @Description: (新增通讯方式设置) 
	 * @param toolSetting
	 * @date 2014年7月25日 下午2:24:38  
	 * @author ah
	 */
	void addToolSetting(ToolSetting toolSetting);

	/**
	 * 根据产品编号查询通信方式设置
	 * @Title: getToolSettingByShopNo 
	 * @Description: (根据产品编号查询通信方式设置) 
	 * @param shopNo
	 * @return
	 * @date 2014年7月31日 下午9:09:02  
	 * @author Administrator
	 */
	ToolSetting getToolSettingByShopNo(String shopNo);

}
