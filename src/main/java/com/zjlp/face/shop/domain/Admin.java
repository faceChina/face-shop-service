package com.zjlp.face.shop.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * 商务后台管理用户
 * @ClassName: Admin 
 * @Description: (商务后台管理用户) 
 * @author ah
 * @date 2014年7月16日 下午3:59:08
 */
public class Admin implements Serializable {
    
	private static final long serialVersionUID = -5495067591717099877L;
	//主键
	private Long id;
	//登陆用户名
    private String loginaccount;
    //密码
    private String passwd;
    //昵称
    private String nickname;
    //状态（-1：删除 1：正常）
    private Integer states;
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

    public String getLoginaccount() {
        return loginaccount;
    }

    public void setLoginaccount(String loginaccount) {
        this.loginaccount = loginaccount == null ? null : loginaccount.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
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