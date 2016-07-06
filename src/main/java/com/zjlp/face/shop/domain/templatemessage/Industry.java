package com.zjlp.face.shop.domain.templatemessage;

import java.io.Serializable;

public class Industry implements Serializable {

	private static final long serialVersionUID = 7317668389268638754L;
	// 主营行业
	private String industry_id1;
	// 副营行业
	private String industry_id2;
	
	public String getIndustry_id1() {
		return industry_id1;
	}
	public void setIndustry_id1(String industry_id1) {
		this.industry_id1 = industry_id1;
	}
	public String getIndustry_id2() {
		return industry_id2;
	}
	public void setIndustry_id2(String industry_id2) {
		this.industry_id2 = industry_id2;
	}
}
