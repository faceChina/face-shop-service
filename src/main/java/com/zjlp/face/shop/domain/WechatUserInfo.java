package com.zjlp.face.shop.domain;

import java.io.Serializable;

/**
 * 微信用户的授权信息
 * @ClassName: WechatUserInfo 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author Administrator
 * @date 2014年10月25日 下午2:24:46
 */
public class WechatUserInfo implements Serializable {

	private static final long serialVersionUID = -4755348507949473137L;
	
	// 用户唯一标识
	private String openId;
	// 用户昵称
	private String nickname;
	// 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
	private Integer sex;
	// 用户个人资料填写的省份
	private String province;
	// 普通用户个人资料填写的城市
	private String city;
	// 国家，如中国为CN
	private String country;
	// 用户头像
	private String headimgurl;
	// 用户特权信息
	private String privilege;
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getPrivilege() {
		return privilege;
	}
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}
}
