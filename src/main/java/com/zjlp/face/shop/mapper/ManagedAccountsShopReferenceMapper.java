package com.zjlp.face.shop.mapper;

import com.zjlp.face.shop.domain.ManagedAccountsShopReference;

public interface ManagedAccountsShopReferenceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ManagedAccountsShopReference record);

    int insertSelective(ManagedAccountsShopReference record);

    ManagedAccountsShopReference selectByPrimaryKey(Long id);

    
    int updateByPrimaryKeySelective(ManagedAccountsShopReference record);

    int updateByPrimaryKey(ManagedAccountsShopReference record);
    
    void deleteBymanagedAccountId(Long managedAccountId);

	void deleteByShopNo(String shopNo);
}