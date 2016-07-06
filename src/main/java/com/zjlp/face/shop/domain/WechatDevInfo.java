package com.zjlp.face.shop.domain;

import java.io.Serializable;

/**
 * 微信开发者信息
 * @ClassName: WechatDevInfo 
 * @Description: (微信开发者信息) 
 * @author ah
 * @date 2014年9月23日 下午1:55:08
 */
public class WechatDevInfo implements Serializable {

	private static final long serialVersionUID = -7750361784115716036L;
	//第三方用户唯一凭证
	private String appId; 
	//第三方用户唯一凭证密钥
    private String appSecret;
    //体验版域名或ip
    private String urlOrIp;
    //官网网址
    private String officialUrl;
    //图片回调地址
    private String picUrl;
    //wgj的url
    private String wgjUrl;
    
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
	public String getAppSecret() {
		return appSecret;
	}
	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}
	public String getUrlOrIp() {
		return urlOrIp;
	}
	public void setUrlOrIp(String urlOrIp) {
		this.urlOrIp = urlOrIp;
	}
	public String getOfficialUrl() {
		return officialUrl;
	}
	public void setOfficialUrl(String officialUrl) {
		this.officialUrl = officialUrl;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public String getWgjUrl() {
		return wgjUrl;
	}
	public void setWgjUrl(String wgjUrl) {
		this.wgjUrl = wgjUrl;
	}

}
