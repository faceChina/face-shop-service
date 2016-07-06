package com.zjlp.face.shop.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zjlp.face.shop.dao.ShopDao;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.mapper.ShopMapper;
import com.zjlp.face.shop.util.Pagination;

@Repository("ShopDao")
public class ShopDaoImpl implements ShopDao {

    @Autowired
    private SqlSession sqlSession;

    @Override
    public void addShop(Shop shop){
        sqlSession.getMapper(ShopMapper.class).insertSelective(shop);
    }

    @Override
    public void editShop(Shop shop){
        sqlSession.getMapper(ShopMapper.class).updateByPrimaryKeySelective(shop);

    }

    @Override
    public List<ShopDto> findShopPageList(ShopDto dto, Pagination<ShopDto> pagination){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("dto", dto);
        map.put("pagination", pagination);
        return sqlSession.getMapper(ShopMapper.class).selectList(map);
    }

    @Override
    public Integer getCount(ShopDto dto){

        return sqlSession.getMapper(ShopMapper.class).getCount(dto);
    }

    @Override
    public Shop getShop(Shop shop){
        return sqlSession.getMapper(ShopMapper.class).selectShop(shop);
    }

    @Override
    public Shop getShopByWechat(Shop shop){
        return sqlSession.getMapper(ShopMapper.class).selectByWechat(shop);
    }

    @Override
    public void editShopByNo(Shop shop){
        sqlSession.getMapper(ShopMapper.class).updateShop(shop);
    }

    @Override
    public void deleteGoodRecommend(String shopNo){
        sqlSession.getMapper(ShopMapper.class).deleteGoodRecommend(shopNo);
    }

	@Override
	public Integer getShopCountByUserId(Long userId) {
		return sqlSession.getMapper(ShopMapper.class).getShopCountByUserId(userId);
	}

}
