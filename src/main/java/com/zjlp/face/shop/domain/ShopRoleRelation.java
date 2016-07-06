package com.zjlp.face.shop.domain;

import java.io.Serializable;

import com.zjlp.face.shop.util.ConstantsUtil;

public class ShopRoleRelation implements Serializable{
	
	private static final long serialVersionUID = 1397405482648066336L;
	//主键
	private Long id;
	//产品编号
    private String shopNo;
    //权限id
    private Long roleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
    
    /**
     * 初始化权限
     * @Title: _generateRole
     * @Description: (初始化权限)
     * @param no
     * @param type
     * @return
     * @date 2014年7月25日 上午10:50:13
     * @author ah
     */
    public static ShopRoleRelation _generateRole(String no, Integer type){
        ShopRoleRelation shopRoleRelation = new ShopRoleRelation();
        shopRoleRelation.setShopNo(no);
        if(ConstantsUtil.CLASSIFICATION_GW.equals(type)){
            shopRoleRelation.setRoleId(ConstantsUtil.ROLE_GW);
        }else if(ConstantsUtil.CLASSIFICATION_SC.equals(type)){
            shopRoleRelation.setRoleId(ConstantsUtil.ROLE_SC);
        }else if(ConstantsUtil.CLASSIFICATION_LP.equals(type)){
            shopRoleRelation.setRoleId(ConstantsUtil.ROLE_LP);
        }else{
            shopRoleRelation.setRoleId(ConstantsUtil.ROLE_PF);
        }
        return shopRoleRelation;
    }
}