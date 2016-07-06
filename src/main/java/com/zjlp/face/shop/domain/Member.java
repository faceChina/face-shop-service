package com.zjlp.face.shop.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member implements Serializable{
   
	private static final long serialVersionUID = -3276522300146695399L;
	//主键
	private Long id;
	//产品编号
    private Long adminId;
    //会员名称
    private String name;
    //消费额
    private Long consumptionAmout;
	//折扣
    private Integer discount;
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
    
    public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Long getConsumptionAmout() {
        return consumptionAmout;
    }

    public void setConsumptionAmout(Long consumptionAmout) {
        this.consumptionAmout = consumptionAmout;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
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
    public Member() {
		// TODO Auto-generated constructor stub
	}
    public static List<Member> initMembers(Long adminId, Date time) {
    	int discount = 100;
    	List<Member> members = new ArrayList<Member>();
    	for(int i=0; i<4; i++) {
    		Member member = new Member();
    		switch (i) {
			case 0:
				member.setName("普通会员");
				member.setConsumptionAmout(0l);
				member.setAdminId(adminId);
				member.setDiscount(discount);
				member.setCreateTime(time);
				member.setUpdateTime(time);
		    	members.add(member);
				break;
			case 1:
				member.setName("金卡会员");
				member.setConsumptionAmout(200l);
				member.setAdminId(adminId);
				member.setDiscount(discount);
				member.setCreateTime(time);
				member.setUpdateTime(time);
				members.add(member);
				break;
			case 2:
				member.setName("白金卡会员");
				member.setConsumptionAmout(1000l);
				member.setAdminId(adminId);
				member.setDiscount(discount);
				member.setCreateTime(time);
				member.setUpdateTime(time);
				members.add(member);
				break;
			case 3:
				member.setName("钻石卡会员");
				member.setConsumptionAmout(3000l);
				member.setAdminId(adminId);
				member.setDiscount(discount);
				member.setCreateTime(time);
				member.setUpdateTime(time);
				members.add(member);
				break;
			default:
				break;
			}
    	}
    	return members;
    } 
}