package com.zjlp.face.shop.util;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Map;

import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.zjlp.face.shop.exception.enums.BaseExceptionEnum;
/**
 * 断言异常工具类
 * @ClassName: AssertUtil 
 * @Description: (用于程序中断言对象，并抛出指定异常) 
 * @author dzq
 * @date 2014年7月16日 上午11:40:40
 */
public class AssertUtil extends Assert{
	
	/**
	 * 集合必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static <E> void notEmpty(Collection<E> collection,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum) throws Exception{
		if (CollectionUtils.isEmpty(collection)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class); 
			RuntimeException e = con.newInstance(baseExceptionEnum); 
			throw e;
		}
	}
	/**
	 * 集合必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param message 异常信息	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static <E> void notEmpty(Collection<E> collection,Class<? extends RuntimeException> clazz,String message) throws Exception{
		if (CollectionUtils.isEmpty(collection)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(String.class); 
			RuntimeException e = con.newInstance(message); 
			throw e;
		}
	}
	/**
	 * 对象必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object 判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举
	 * @param message 异常附加信息
	 * @throws Exception
	 * @date 2014年7月16日 上午11:43:20  
	 * @author dzq
	 */
	public static <E> void notNull(Collection<E> collection,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum, String... message) throws Exception{
		if (CollectionUtils.isEmpty(collection)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class,String[].class); 
			RuntimeException e = con.newInstance(baseExceptionEnum,message); 
			throw e;
		}
	}
	/**
	 * 集合必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static  void notEmpty(Map<?, ?> map,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum) throws Exception{
		if (CollectionUtils.isEmpty(map)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class); 
			RuntimeException e = con.newInstance(baseExceptionEnum); 
			throw e;
		}
	}
	/**
	 * 集合必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param message 异常信息	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static  void notEmpty(Map<?, ?> map,Class<? extends RuntimeException> clazz,String message) throws Exception{
		if (CollectionUtils.isEmpty(map)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(String.class); 
			RuntimeException e = con.newInstance(message); 
			throw e;
		}
	}
	/**
	 * 对象必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object 判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举
	 * @param message 异常附加信息
	 * @throws Exception
	 * @date 2014年7月16日 上午11:43:20  
	 * @author dzq
	 */
	public static  void notEmpty(Map<?, ?> map,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum, String... message) throws Exception{
		if (CollectionUtils.isEmpty(map)) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class,String[].class); 
			RuntimeException e = con.newInstance(baseExceptionEnum,message); 
			throw e;
		}
	}
	
	/**
	 * 对象必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static void notNull(Object object,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum) throws Exception{
		if (null == object) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class); 
			RuntimeException e = con.newInstance(baseExceptionEnum); 
			throw e;
		}
	}
	/**
	 * 对象必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object 判定对象
	 * @param clazz	    异常类型
	 * @param baseExceptionEnum 异常枚举
	 * @param message 异常附加信息
	 * @throws Exception
	 * @date 2014年7月16日 上午11:43:20  
	 * @author dzq
	 */
	public static void notNull(Object object,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum, String... message) throws Exception{
		if (null == object) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class,String[].class); 
			RuntimeException e = con.newInstance(baseExceptionEnum,message); 
			throw e;
		}
	}
	
	/**
	 * 为TRUE则抛出指定异常
	 * @Title: isTrue 
	 * @Description: (为TRUE则抛出指定异常) 
	 * @param object
	 * @param clazz
	 * @param baseExceptionEnum
	 * @param message
	 * @throws Exception
	 * @date 2014年7月25日 下午8:25:18  
	 * @author ah
	 */
	public static void isTrue(boolean expression,Class<? extends RuntimeException> clazz,BaseExceptionEnum baseExceptionEnum, String... message) throws Exception{
		if (expression) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(BaseExceptionEnum.class,String[].class); 
			RuntimeException e = con.newInstance(baseExceptionEnum,message); 
			throw e;
		}
	}
	
	/**
	 * 对象必须不为空，为空则抛出指定异常
	 * @Title: notNull 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param object  判定对象
	 * @param clazz	    异常类型
	 * @param message 异常信息	
	 * @throws Exception
	 * @date 2014年7月16日 上午11:41:47  
	 * @author dzq
	 */
	public static void notNull(Object object,Class<? extends RuntimeException> clazz,String message) throws Exception{
		if (null == object) {
			Constructor<? extends RuntimeException> con = clazz.getConstructor(String.class); 
			RuntimeException e = con.newInstance(message); 
			throw e;
		}
	}
	
}
