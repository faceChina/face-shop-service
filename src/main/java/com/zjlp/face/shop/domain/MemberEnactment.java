package com.zjlp.face.shop.domain;

import java.io.Serializable;
import java.util.Date;
/**
 * 会员设定实体
 * @ClassName: MemberEnactment 
 * @Description: (这里用一句话描述这个类的作用) 
 * @author dzq
 * @date 2014年6月18日 上午10:11:38
 */
public class MemberEnactment implements Serializable{
	
	private static final long serialVersionUID = -3237628666696501548L;

	private Long id;
	//商铺编码
    private Long adminId;
    //会员卡名称
    private String cardName;
    //图片路径
    private String imgPath;
    //会员卡名称颜色
    private String cardNameColor;
    //卡号文字颜色
    private String cardNoColor;
    //卡号编码
    private String cardCode;
    //起始卡号
    private Integer startNo;
    //截止卡号
    private Integer endNo;
    //状态 -1：删除，0：冻结，1：正常
    private Integer states;
    //创建时间
    private Date createTime;
    //修改时间
    private Date updateTime;
    //会员简介
    private String memberContent;
    
    public static MemberEnactment initMemberEnactment(Long adminId,Date time){
    	MemberEnactment memberEnactment = new MemberEnactment();
    	memberEnactment.setAdminId(adminId);
    	memberEnactment.cardName="会员卡";
    	memberEnactment.cardNameColor="#ffffff";
    	memberEnactment.cardNoColor="#ffffff";
    	memberEnactment.cardCode="BSD";
    	memberEnactment.startNo=1;
    	memberEnactment.endNo=65535;
    	memberEnactment.states=1;
    	memberEnactment.createTime=time;
    	memberEnactment.updateTime=time;
    	return memberEnactment;
    }
	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getCardName() {
        return cardName;
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath == null ? null : imgPath.trim();
    }

    public String getCardNameColor() {
        return cardNameColor;
    }

    public void setCardNameColor(String cardNameColor) {
        this.cardNameColor = cardNameColor == null ? null : cardNameColor.trim();
    }

    public String getCardNoColor() {
        return cardNoColor;
    }

    public void setCardNoColor(String cardNoColor) {
        this.cardNoColor = cardNoColor == null ? null : cardNoColor.trim();
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode == null ? null : cardCode.trim();
    }

    public Integer getStartNo() {
        return startNo;
    }

    public void setStartNo(Integer startNo) {
        this.startNo = startNo;
    }

    public Integer getEndNo() {
        return endNo;
    }

    public void setEndNo(Integer endNo) {
        this.endNo = endNo;
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

    public String getMemberContent() {
        return memberContent;
    }

    public void setMemberContent(String memberContent) {
        this.memberContent = memberContent == null ? null : memberContent.trim();
    }
	public Long getAdminId() {
		return adminId;
	}
	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
}