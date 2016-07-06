package com.zjlp.face.shop.domain;

import java.io.Serializable;

/**
 * 网页授权信息
 * @ClassName: GrandInfo 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author ah
 * @date 2014年10月25日 下午1:49:19
 */
public class GrandInfo implements Serializable {

	private static final long serialVersionUID = -3170699467116944163L;

	// 网页授权接口调用凭证
	private String accessToken;
	// 超时时间，单位（秒）
	private Integer expiresIn;
	// 用户刷新access_token
	private String refreshToken;
	// 用户唯一标识
	private String openId;
	// 用户授权的作用域，使用逗号（,）分隔
	private String scope;
	
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public Integer getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(Integer expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getRefreshToken() {
		return refreshToken;
	}
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getScope() {
		return scope;
	}
	public void setScope(String scope) {
		this.scope = scope;
	}
}
