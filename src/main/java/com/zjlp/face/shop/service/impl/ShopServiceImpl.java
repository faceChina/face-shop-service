package com.zjlp.face.shop.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zjlp.face.shop.dao.ShopDao;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.service.ShopService;
import com.zjlp.face.shop.util.ConstantsUtil;
import com.zjlp.face.shop.util.Pagination;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDao shopDao;

    @Override
    public void addShop(Shop shop){
        shopDao.addShop(shop);
    }

    @Override
    public void editShop(Shop shop){
        shopDao.editShop(shop);

    }

    @Override
    public Pagination<ShopDto> findShopPageList(ShopDto dto, Pagination<ShopDto> pagination){
        Integer totalRow = shopDao.getCount(dto);
        List<ShopDto> datas = shopDao.findShopPageList(dto, pagination);
        pagination.setTotalRow(totalRow);
        pagination.setDatas(datas);
        return pagination;
    }

    @Override
    public Shop getShopByInvitationCode(String invitationCode){
        Shop shop = new Shop();
        shop.setStatus(ConstantsUtil.STATE_NORMAL);
        shop.setInvitationCode(invitationCode);
        return shopDao.getShop(shop);
    }

    @Override
    public Shop getShopByWechat(String wechat, String shopNo){
        Shop shop = new Shop();
        shop.setStatus(ConstantsUtil.STATE_NORMAL);
        shop.setWechat(wechat);
        shop.setNo(shopNo);
        return shopDao.getShopByWechat(shop);
    }

    @Override
    public Shop getShopByShopNo(String shopNo){
        Shop shop = new Shop();
        shop.setStatus(ConstantsUtil.STATE_NORMAL);
        shop.setNo(shopNo);
        return shopDao.getShop(shop);
    }

    @Override
    public void editShopByNo(Shop shop){
        shopDao.editShopByNo(shop);
    }

    @Override
    public void deleteGoodRecommend(String shopNo){
        shopDao.deleteGoodRecommend(shopNo);
    }

	@Override
	public Integer getShopCountByUserId(Long userId) {
		return shopDao.getShopCountByUserId(userId);
	}

}
