package com.zjlp.face.shop.domain.templatemessage.order;

import com.zjlp.face.shop.domain.templatemessage.DataValue;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessageData;

/**
 * 订单状态模板消息
 * @ClassName: OrderStates 
 * @Description: (订单状态模板消息) 
 * @author ah
 * @date 2015年3月9日 下午2:45:45
 */
public class OrderStatus implements TemplateMessageData {

	// 开头
	private DataValue first;
	// 订单编号
	private DataValue OrderSn;
	// 订单状态
	private DataValue OrderStatus;
	// 备注
	private DataValue remark;
	
	public DataValue getFirst() {
		return first;
	}
	public void setFirst(DataValue first) {
		this.first = first;
	}
	public DataValue getOrderSn() {
		return OrderSn;
	}
	public void setOrderSn(DataValue orderSn) {
		OrderSn = orderSn;
	}
	public DataValue getOrderStatus() {
		return OrderStatus;
	}
	public void setOrderStatus(DataValue orderStatus) {
		OrderStatus = orderStatus;
	}
	public DataValue getRemark() {
		return remark;
	}
	public void setRemark(DataValue remark) {
		this.remark = remark;
	}
}
