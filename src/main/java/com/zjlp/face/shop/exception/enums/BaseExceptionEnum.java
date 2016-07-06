package com.zjlp.face.shop.exception.enums;

/**
 * 错误列表统一接口
 * @author LYS
 *
 */
public interface BaseExceptionEnum {

	/**
	 * 获取错误代码
	 */
	String getErrCode();

	/**
	 * 获取内部错误信息
	 */
	String getInnerMsg();

	/**
	 * 获取外部错误信息
	 */
	String getExternalMsg();

	/**
	 * 返回的错误页面
	 */
	String getErrPage();
}
