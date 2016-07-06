package com.zjlp.face.shop.exception;

import com.zjlp.face.shop.exception.enums.BaseExceptionEnum;
import com.zjlp.face.shop.exception.enums.ShopExceptionEnum;

public class BaseException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	protected BaseExceptionEnum baseExceptionEnum;
	
	private static final String[] PARAM_ARR = {"{0}", "{1}", 
		"{2}", "{3}", "{4}", "{5}", "{6}",
		"{7}", "{8}", "{9}"};
	
	protected String[] params;
		
	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}

	public BaseException(BaseExceptionEnum baseExceptionEnum){
		//日志
		super(baseExceptionEnum.getExternalMsg());
		this.baseExceptionEnum = baseExceptionEnum;
	}
	
	public  BaseException(BaseExceptionEnum baseExceptionEnum,Throwable cause){
		//日志
		super(baseExceptionEnum.getExternalMsg(),cause);
		this.baseExceptionEnum = baseExceptionEnum;
	}
	
	public BaseException(BaseExceptionEnum baseExceptionEnum, String... params) {
		super(baseExceptionEnum.getExternalMsg());
		this.baseExceptionEnum = baseExceptionEnum;
		this.params = params;
	}
	
	public BaseException(BaseExceptionEnum baseExceptionEnum,Throwable cause,String... params) {
		super(baseExceptionEnum.getExternalMsg(),cause);
		this.baseExceptionEnum = baseExceptionEnum;
		this.params = params;
	}

	
	/**
	 * 返回的错误页面

	 * @Title: getUrl 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @date 2014年7月11日 上午11:40:02  
	 * @author dzq
	 */
	public String getErrPage(){
		if (null == baseExceptionEnum) {
			return null;
		}
		return baseExceptionEnum.getErrPage();
	}
	
	/**
	 * 获取内部错误信息
	 * @Title: getInnerMsg 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @date 2014年7月11日 上午11:39:51  
	 * @author dzq
	 */
	public String getInnerMsg() {
		if (null == baseExceptionEnum) {
			return null;
		}
		String innerMsg = baseExceptionEnum.getInnerMsg();
		if (null == params) {
			return innerMsg;
		}
		for (int i = 0; i < params.length; i++) {
			innerMsg = innerMsg.replace(PARAM_ARR[i], "["+params[i]+"]");
		}
		return innerMsg;
	}
	
	/**
	 * 获取外部错误信息
	 * @Title: getExternalMsg 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @date 2014年7月11日 上午11:39:41  
	 * @author dzq
	 */
	public String getExternalMsg() {
		if (null == baseExceptionEnum) {
			return null;
		}
		return baseExceptionEnum.getExternalMsg();
	}
	
	/**
	 * 获取错误代码
	 * @Title: getErrCode 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @date 2014年7月11日 上午11:39:28  
	 * @author dzq
	 */
	public String getErrCode() {
		if (null == baseExceptionEnum) {
			return null;
		}
		return baseExceptionEnum.getErrCode();
	}
	
	
	public static void main(String[] args) {
		try {
			if (true) {
				throw new BaseException(ShopExceptionEnum.SHOP_00001, "凯旋路781号", "");
			}
		} catch (BaseException e) {
			System.out.println(e.getInnerMsg());
			System.out.println(e.getErrPage());
			System.out.println(e.getExternalMsg());
			System.out.println(e.getErrCode());
		}
	}
}
