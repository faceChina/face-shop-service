package com.zjlp.face.shop.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 * @ClassName: User 
 * @Description: (用户) 
 * @author ah
 * @date 2014年7月16日 下午4:26:21
 */
public class User implements Serializable {
   
	private static final long serialVersionUID = 7022078144508299158L;
	//主键
	private Long id;
	//来源：1、来源于微信
    private Integer source;
    //我的邀请码，必填，系统自动生成
    private String myInvitationCode;
    //昵称
    private String nickname;
    //微信用户标识，对当前公众号唯一
    private String openId;
    //用户唯一标识
    private String fakeId;
    //站内唯一识别ID
    private String token;
    //登录名
    private String loginAccount;
    //密码
    private String passwd;
    //账户类型
    private Integer type;
    //性别
    private Integer sex;
    //邀请码
    private String invitationCode;
    //用户语言
    private String language;
    //用户头像
    private String headimgurl;
    //用户关注时间
    private Date subscribeTime;
    //手机号码
    private String phone;
    //身份证
    private String identity;
    //联系人(真实姓名)
    private String contacts;
    //地区编码
    private Integer areaCode;
    //地址
    private String address;
    //状态 -1：删除，0：冻结，1：正常
    private Integer status;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getMyInvitationCode() {
        return myInvitationCode;
    }

    public void setMyInvitationCode(String myInvitationCode) {
        this.myInvitationCode = myInvitationCode == null ? null : myInvitationCode.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public String getFakeId() {
        return fakeId;
    }

    public void setFakeId(String fakeId) {
        this.fakeId = fakeId == null ? null : fakeId.trim();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount == null ? null : loginAccount.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language == null ? null : language.trim();
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity == null ? null : identity.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}