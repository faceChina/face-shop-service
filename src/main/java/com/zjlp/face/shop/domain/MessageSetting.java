package com.zjlp.face.shop.domain;

import java.util.Date;

public class MessageSetting {
    private Long id;

    private Long messageBodyId;

    private String shopNo;

    private Integer eventType;

    private Integer recoveryMode;

    private String keyWord;

    private Integer matchingType;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMessageBodyId() {
        return messageBodyId;
    }

    public void setMessageBodyId(Long messageBodyId) {
        this.messageBodyId = messageBodyId;
    }

    public String getShopNo() {
        return shopNo;
    }

    public void setShopNo(String shopNo) {
        this.shopNo = shopNo == null ? null : shopNo.trim();
    }

    public Integer getEventType() {
        return eventType;
    }

    public void setEventType(Integer eventType) {
        this.eventType = eventType;
    }

    public Integer getRecoveryMode() {
        return recoveryMode;
    }

    public void setRecoveryMode(Integer recoveryMode) {
        this.recoveryMode = recoveryMode;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    public Integer getMatchingType() {
        return matchingType;
    }

    public void setMatchingType(Integer matchingType) {
        this.matchingType = matchingType;
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