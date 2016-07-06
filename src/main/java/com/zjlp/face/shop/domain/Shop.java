package com.zjlp.face.shop.domain;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.util.ConstantsUtil;
import com.zjlp.face.shop.util.DateUtil;
import com.zjlp.face.shop.util.GenerateCode;
import com.zjlp.face.shop.util.enums.DateStyle;

/**
 * 店铺（产品）
 * @ClassName: Shop 
 * @Description: (店铺（产品）) 
 * @author ah
 * @date 2014年7月16日 下午4:02:29
 */
public class Shop implements Serializable {
    
	private static final long serialVersionUID = 429903016436867774L;
	//店铺编码
	private String no;
	//用户ID
    private Long userId;
    //店铺名称
    private String name;
    //联系人
    private String contacts;
    //市场人员
    private String marketer;
    //运营人员
    private String operater;
    //手机
    private String cell;
    //地区编码
    private Integer areaCode;
    //地址
    private String address;
    //激活时间
    private Date activationTime;
    //微信账户
    private String wechat;
    //密码
    private String passwd;
    //来源:1、微信
    private Integer source=1;
    //绑定时间
    private Date bindingTime;
    //签约时间
    private Date signingTime;
    //有效时间
    private Date effectiveTime;
    //状态 -1：删除，0：未激活，1：正常
    private Integer status;
    //授权码
    private String authorizationCode;
    //类型：1、商铺 2、官网 3 脸谱 9、微平台
    private Integer type;
    //站内用户唯一识别ID
    private String token;
    //店铺邀请码
    private String invitationCode;
    //上家邀请码
    private String onInvitationCode;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //简介
    private String shopContent;
    //应用ID
    private String appId;
    //应用秘钥
    private String appSecret;
    //是否是认证的服务号或者订阅号
    private Integer authenticate;

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

	public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no == null ? null : no.trim();
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getMarketer() {
        return marketer;
    }

    public void setMarketer(String marketer) {
        this.marketer = marketer == null ? null : marketer.trim();
    }

    public String getOperater() {
        return operater;
    }

    public void setOperater(String operater) {
        this.operater = operater == null ? null : operater.trim();
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell == null ? null : cell.trim();
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

    public Date getActivationTime() {
        return activationTime;
    }

    public void setActivationTime(Date activationTime) {
        this.activationTime = activationTime;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat == null ? null : wechat.trim();
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public Date getBindingTime() {
        return bindingTime;
    }

    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    public Date getSigningTime() {
        return signingTime;
    }

    public void setSigningTime(Date signingTime) {
        this.signingTime = signingTime;
    }

    public Date getEffectiveTime() {
        return effectiveTime;
    }

    public void setEffectiveTime(Date effectiveTime) {
        this.effectiveTime = effectiveTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getAuthorizationCode() {
        return authorizationCode;
    }

    public void setAuthorizationCode(String authorizationCode) {
        this.authorizationCode = authorizationCode == null ? null : authorizationCode.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }

    public String getInvitationCode() {
        return invitationCode;
    }

    public void setInvitationCode(String invitationCode) {
        this.invitationCode = invitationCode == null ? null : invitationCode.trim();
    }

    public String getOnInvitationCode() {
        return onInvitationCode;
    }

    public void setOnInvitationCode(String onInvitationCode) {
        this.onInvitationCode = onInvitationCode == null ? null : onInvitationCode.trim();
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

    public String getShopContent() {
        return shopContent;
    }

    public void setShopContent(String shopContent) {
        this.shopContent = shopContent == null ? null : shopContent.trim();
    }
    
    /**
     * 初始化产品
     * 
     * @Title: _generateShop
     * @Description: (初始化产品)
     * @param no
     * @param user
     * @param dto
     * @param operateUserName
     * @return
     * @date 2014年7月25日 上午11:37:31
     * @author ah
     */
    public static Shop _generateShop(String no, User user, ShopDto dto){
        Date date = new Date();
        Shop shop = new Shop();
        // 生成产品邀请码
        String invitationCode = GenerateCode.generateInvitationCode(user.getMyInvitationCode(), dto.getType());
        shop.setNo(no);
        shop.setName(dto.getName());
        shop.setType(dto.getType());
        shop.setAuthorizationCode(dto.getAuthorizationCode());
        shop.setSigningTime(dto.getSigningTime());
        shop.setUserId(user.getId());
        shop.setMarketer(dto.getMarketer());
        shop.setOperater(dto.getOperater());
        shop.setOnInvitationCode(dto.getOnInvitationCode());
        shop.setContacts(user.getContacts());
        shop.setCell(user.getPhone());
        shop.setInvitationCode(invitationCode);
        shop.setToken(user.getToken());
        shop.setSource(dto.getSource());
        shop.setStatus(ConstantsUtil.STATE_NORMAL);
        shop.setCreateTime(date);
        shop.setUpdateTime(date);
        // 有效期
        shop.setEffectiveTime(_settingEffectiveTime(dto.getSigningTime(), dto.getType()));
        return shop;
    }
    
    /**
     * 获得有效时间
     * @Title: _settingEffectiveTime
     * @Description: (普通产品：签约时间加上一年零七天 平台产品：2099年12月31日)
     * @param signingTime
     * @return
     * @date 2014年7月24日 下午8:25:38
     * @author ah
     */
    public static Date _settingEffectiveTime(Date signingTime, Integer type){
        Calendar cal = Calendar.getInstance();
        if(null != signingTime && !ConstantsUtil.CLASSIFICATION_PF.equals(type)){
            cal.setTime(signingTime);
            // 一年
            cal.add(Calendar.YEAR, 1);
            // 七天
            cal.add(Calendar.DAY_OF_MONTH, 7);
        }else{
            cal.set(Calendar.YEAR, 2099);
            cal.set(Calendar.MONTH, 11);
            int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            cal.set(Calendar.DAY_OF_MONTH, lastDay);
        }
        return cal.getTime();
    }
    
    @Override
    public String toString() {
    	StringBuffer stringBuffer = new StringBuffer();
    	stringBuffer.append("Shop [")
    	.append("no=").append(this.no).append(",")
    	.append("name=").append(this.name).append(",")
    	.append("type=").append(this.type).append(",")
    	.append("authorizationCode=").append(this.authorizationCode).append(",")
    	.append("signingTime=").append(DateUtil.DateToString(this.signingTime, DateStyle.YYYY_MM_DD)).append(",")
    	.append("effectiveTime=").append(this.effectiveTime).append(",")
    	.append("userId=").append(this.userId).append(",")
    	.append("marketer=").append(this.marketer).append(",")
    	.append("operater=").append(this.operater).append(",")
    	.append("onInvitationCode=").append(this.onInvitationCode).append(",")
    	.append("contacts=").append(this.contacts).append(",")
    	.append("cell=").append(this.cell).append(",")
    	.append("invitationCode=").append(this.invitationCode).append(",")
    	.append("token=").append(this.token).append(",")
    	.append("source=").append(this.source).append(",")
    	.append("status=").append(this.status).append("]");
    	return stringBuffer.toString();
    }

	public Integer getAuthenticate() {
		return authenticate;
	}

	public void setAuthenticate(Integer authenticate) {
		this.authenticate = authenticate;
	}
}