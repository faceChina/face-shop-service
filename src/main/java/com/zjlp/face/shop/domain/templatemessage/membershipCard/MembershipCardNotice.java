package com.zjlp.face.shop.domain.templatemessage.membershipCard;

import com.zjlp.face.shop.domain.templatemessage.DataValue;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;

/**
 * 会员卡领取通知模板消息
 * @ClassName: MembershipCardNotice 
 * @Description: (会员卡领取通知模板消息) 
 * @author ah
 * @date 2015年3月9日 下午2:21:15
 */
public class MembershipCardNotice implements TemplateMessageData {

	// 开头
	private DataValue first;
	// 会员编号
	private DataValue keyword1;
	// 会员姓名
	private DataValue keyword2;
	// 会员电话
	private DataValue keyword3;
	// 申请时间
	private DataValue keyword4;
	// 备注
	private DataValue remark;
	
	public DataValue getFirst() {
		return first;
	}
	public void setFirst(DataValue first) {
		this.first = first;
	}
	public DataValue getKeyword1() {
		return keyword1;
	}
	public void setKeyword1(DataValue keyword1) {
		this.keyword1 = keyword1;
	}
	public DataValue getKeyword2() {
		return keyword2;
	}
	public void setKeyword2(DataValue keyword2) {
		this.keyword2 = keyword2;
	}
	public DataValue getKeyword3() {
		return keyword3;
	}
	public void setKeyword3(DataValue keyword3) {
		this.keyword3 = keyword3;
	}
	public DataValue getKeyword4() {
		return keyword4;
	}
	public void setKeyword4(DataValue keyword4) {
		this.keyword4 = keyword4;
	}
	public DataValue getRemark() {
		return remark;
	}
	public void setRemark(DataValue remark) {
		this.remark = remark;
	}
}
