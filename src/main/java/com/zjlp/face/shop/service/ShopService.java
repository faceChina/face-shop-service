package com.zjlp.face.shop.service;

import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.util.Pagination;

/**
 * 产品基础服务接口
 * 
 * @ClassName: ShopService
 * @Description: (产品基础服务接口)
 * @author ah
 * @date 2014年7月18日 下午5:48:12
 */
public interface ShopService {

    /**
     * 新增产品
     * 
     * @Title: addShop
     * @Description: (新增产品)
     * @param shop
     * @date 2014年7月24日 下午7:46:43
     * @author ah
     */
    void addShop(Shop shop);

    /**
     * 编辑产品
     * 
     * @Title: editShop
     * @Description: (编辑产品)
     * @param shop
     * @date 2014年7月25日 下午5:28:35
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
     * @date 2014年7月18日 下午6:04:18
     * @author ah
     */
    Pagination<ShopDto> findShopPageList(ShopDto dto, Pagination<ShopDto> pagination);

    /**
     * 根据邀请码查询产品
     * 
     * @Title: getShopByInvitationCode
     * @Description: (根据邀请码查询产品)
     * @param invitationCode
     * @return
     * @date 2014年7月25日 上午9:42:48
     * @author ah
     */
    Shop getShopByInvitationCode(String invitationCode);

    /**
     * 通过微信号查询产品
     * 
     * @Title: getShopByWechat
     * @Description: (通过微信号查询产品)
     * @param wechat
     * @param shopNo
     * @return
     * @date 2014年7月25日 下午8:15:01
     * @author ah
     */
    Shop getShopByWechat(String wechat, String shopNo);

    /**
     * 根据产品编号查询产品
     * 
     * @Title: getShopByShopNo
     * @Description: (根据产品编号查询产品)
     * @return
     * @date 2014年7月25日 下午9:23:19
     * @author ah
     */
    Shop getShopByShopNo(String shopNo);

    /**
     * 根据产品编号编辑产品
     * 
     * @Title: editShopByNo
     * @Description: (这里用一句话描述这个方法的作用)
     * @param shop
     * @date 2014年8月27日 下午1:54:12
     * @author ah
     */
    void editShopByNo(Shop shop);

    /**
     * @Description: 删除shop时删除商品推荐表中该shop的商品
     * @param shopNo
     * @date: 2014年9月16日 下午6:57:11
     * @author: zyl
     */
    void deleteGoodRecommend(String shopNo);

    /**
     * 根据用户id查询店铺个数
     * @Title: getShopCountByUserId 
     * @Description: (根据用户id查询店铺个数) 
     * @param userId
     * @return
     * @date 2014年9月29日 下午9:53:25  
     * @author ah
     */
	Integer getShopCountByUserId(Long userId);

}
