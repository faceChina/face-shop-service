package com.zjlp.face.shop.dto;

import com.zjlp.face.shop.domain.User;

public class UserDto extends User {

	private static final long serialVersionUID = 6918057423096711931L;
	
	//省市区
	private String areaDescription;

	public String getAreaDescription() {
		return areaDescription;
	}

	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

}
