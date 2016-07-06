package com.zjlp.face.shop.dao;

import java.util.List;

import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.util.Pagination;

/**
 * 产品持久层
 * 
 * @ClassName: ShopDao
 * @Description: (产品持久层)
 * @author ah
 * @date 2014年7月19日 下午3:48:57
 */
public interface ShopDao {

    /**
     * 新增产品
     * 
     * @Title: addShop
     * @Description: (新增产品)
     * @param shop
     * @date 2014年7月25日 上午9:47:06
     * @author ah
     */
    void addShop(Shop shop);

    /**
     * 编辑产品
     * 
     * @Title: editShop
     * @Description: (编辑产品)
     * @param shop
     * @date 2014年7月25日 下午5:30:15
     * @author ah
     */
    void editShop(Shop shop);

    /**
     * 查询产品分页列表
     * 
     * @Title: findShopPageList
     * @Description: (查询产品分页列表)
     * @param dto
     * @param pagination
     * @return
     * @date 2014年7月24日 下午2:44:02
     * @author ah
     */
    List<ShopDto> findShopPageList(ShopDto dto, Pagination<ShopDto> pagination);

    /**
     * 查询产品总数
     * 
     * @Title: getCount
     * @Description: (查询产品总数)
     * @param dto
     * @return
     * @date 2014年7月24日 下午2:44:29
     * @author ah
     */
    Integer getCount(ShopDto dto);

    /**
     * 根据产品邀请码查询产品
     * 
     * @Title: getShopByInvitationCode
     * @Description: (根据产品邀请码查询产品)
     * @param shop
     * @return
     * @date 2014年7月25日 上午9:48:03
     * @author ah
     */
    Shop getShop(Shop shop);

    /**
     * 通过微信号查询产品
     * 
     * @Title: getShopByWechat
     * @Description: (通过微信号查询产品)
     * @param shop
     * @return
     * @date 2014年7月26日 下午2:10:54
     * @author ah
     */
    Shop getShopByWechat(Shop shop);

    /**
     * 根据产品编号编辑产品
     * 
     * @Title: editShopByNo
     * @Description: (这里用一句话描述这个方法的作用)
     * @param shop
     * @date 2014年8月27日 下午1:55:28
     * @author Administrator
     */
    void editShopByNo(Shop shop);

    void deleteGoodRecommend(String shopNo);

    /**
     * 根据用户id查询店铺个数
     * @Title: getShopCountByUserId 
     * @Description: (根据用户id查询店铺个数) 
     * @param userId
     * @return
     * @date 2014年9月29日 下午9:55:12  
     * @author Administrator
     */
	Integer getShopCountByUserId(Long userId);

}
