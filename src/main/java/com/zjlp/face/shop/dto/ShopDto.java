package com.zjlp.face.shop.dto;

import com.zjlp.face.shop.domain.Shop;

public class ShopDto extends Shop {

	private static final long serialVersionUID = -4179035918544897732L;
	
	//用户账号
	private String loginAccount;
	//分类id
    private Long classificationId;
    //微信url
    private String url;

	public Long getClassificationId() {
		return classificationId;
	}

	public void setClassificationId(Long classificationId) {
		this.classificationId = classificationId;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}

}
