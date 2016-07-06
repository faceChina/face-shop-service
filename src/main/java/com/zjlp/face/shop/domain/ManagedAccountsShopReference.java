package com.zjlp.face.shop.domain;

import java.io.Serializable;

public class ManagedAccountsShopReference implements Serializable{
    
	private static final long serialVersionUID = 864899605070981814L;
	private Long id;
    //管理帐户
    private Long managedAccountId;
    //产品
    private String shopNo;
    //产品类型
    private Integer type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getManagedAccountId() {
        return managedAccountId;
    }

    public void setManagedAccountId(Long managedAccountId) {
        this.managedAccountId = managedAccountId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}