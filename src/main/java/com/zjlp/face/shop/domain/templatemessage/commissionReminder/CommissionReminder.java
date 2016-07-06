package com.zjlp.face.shop.domain.templatemessage.commissionReminder;

import com.zjlp.face.shop.domain.templatemessage.DataValue;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;
/**
 * 佣金提醒模板消息
 * @ClassName: CommissionReminder 
 * @Description: (佣金提醒模板消息) 
 * @author ah
 * @date 2015年3月6日 下午2:54:53
 */
public class CommissionReminder implements TemplateMessageData {

	// 开头
	private DataValue first;
	// 佣金金额
	private DataValue keyword1;
	// 时间
	private DataValue keyword2;
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
	public DataValue getRemark() {
		return remark;
	}
	public void setRemark(DataValue remark) {
		this.remark = remark;
	}
}
