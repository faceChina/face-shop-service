package com.zjlp.face.shop.exception.enums;

/**
 * 错误页面列表
 * @author LYS
 *
 */
public enum ErrorPageEnum {
	
	ERRORPAGE_LOGIN("000","/login"),
	
	ERRORPAGE_500("500", "/m/error/500"),
	
	ERRORPAGE_404("404", "/m/error/404");

	//错误页面代码
	private String errPageCode;
	//错误页面url
	private String errPageUrl;
	
	private ErrorPageEnum(String errPageCode, String errPageUrl) {
		this.errPageCode = errPageCode;
		this.errPageUrl = errPageUrl;
	}

	/**
	 * 通过错误页面代码获取错误页面url
	 * 
	 * @param errPageCode
	 *            错误页面代码
	 * @return 错误页面url
	 */
	public static String getErrUrlByCode(String errPageCode) {
		for (ErrorPageEnum url : ErrorPageEnum.values()) {
			if (url.getErrPageCode().equals(errPageCode)) {
				return url.getErrPageUrl();
			}
		}
		return null;
	}

	/**
	 * 获取错误页面代码
	 */
	public String getErrPageCode() {
		return errPageCode;
	}

	/**
	 * 获取错误页面url
	 */
	public String getErrPageUrl() {
		return errPageUrl;
	}

}
