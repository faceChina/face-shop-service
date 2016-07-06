package com.zjlp.face.shop.domain;

import java.io.Serializable;

/**
 * 微信通用接口凭证
 * @ClassName: AccessToken 
 * @Description: (微信通用接口凭证) 
 * @author ah
 * @date 2014年10月20日 下午3:51:19
 */
public class AccessToken implements Serializable {

	private static final long serialVersionUID = -8943808738891250064L;
	
	// 公众号的全局唯一凭证
	private String token;
	// 凭证有效时间，单位：秒
	private int expiresIn;
	// 错误返回码
	private String errcode;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getExpiresIn() {
		return expiresIn;
	}
	public void setExpiresIn(int expiresIn) {
		this.expiresIn = expiresIn;
	}
	public String getErrcode() {
		return errcode;
	}
	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

}
