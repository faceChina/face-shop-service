package com.zjlp.face.shop.domain.templatemessage;

import java.io.Serializable;

public class TemplateId implements Serializable{

	private static final long serialVersionUID = 6310118154402568293L;
	// 模板库中模板的编号
	private String template_id_short;

	public String getTemplate_id_short() {
		return template_id_short;
	}

	public void setTemplate_id_short(String template_id_short) {
		this.template_id_short = template_id_short;
	}
}
