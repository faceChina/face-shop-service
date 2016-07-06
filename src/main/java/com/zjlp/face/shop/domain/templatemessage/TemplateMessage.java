package com.zjlp.face.shop.domain.templatemessage;

import java.io.Serializable;

public class TemplateMessage implements Serializable {

	private static final long serialVersionUID = -442327176641302740L;
	
	// 接受模板消息的openid
	private String Touser;
	// 模板消息id
	private String template_id;
	// url
	private String url;
	// 颜色
	private String topcolor = "#FF0000";
	// 模板内容
	private TemplateMessageData data;
	
	public String getTouser() {
		return Touser;
	}
	public void setTouser(String touser) {
		this.Touser = touser;
	}
	public String getTemplate_id() {
		return template_id;
	}
	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTopcolor() {
		return topcolor;
	}
	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}
	public TemplateMessageData getData() {
		return data;
	}
	public void setData(TemplateMessageData data) {
		this.data = data;
	}
}
