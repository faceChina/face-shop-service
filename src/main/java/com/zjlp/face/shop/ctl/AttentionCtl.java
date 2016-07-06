package com.zjlp.face.shop.ctl;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zjlp.face.shop.business.WechatBusiness;
import com.zjlp.face.shop.util.wechat.MessageUtil;
import com.zjlp.face.shop.util.wechat.SignUtil;

@Controller
@Scope("prototype")
public class AttentionCtl {
	
	@Autowired
	private WechatBusiness WechatBusiness;
	
	/**
	 * 请求校验（确认请求来自微信服务器）
	 */
	@RequestMapping(value="/weixin/{shopNo}/attention",method = RequestMethod.GET)
	public void attention(@PathVariable String shopNo, String signature, String timestamp, String nonce, String echostr, HttpServletResponse response) throws IOException{
		
		PrintWriter out = response.getWriter();
		// 通过检验signature对请求进行校验，若校验成功则原样返回echostr，表示接入成功，否则接入失败
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
		out = null;
	}
	
	/**
	 * 处理微信服务器发了的消息
	 */
	@RequestMapping(value="/weixin/{shopNo}/attention",method = RequestMethod.POST)
	public void attention(@PathVariable String shopNo, HttpServletRequest request, HttpServletResponse response) throws IOException{
		try {
			StopWatch clock = new StopWatch();
			clock.start(); // 计时开始
			// xml请求解析
			Map<String, String> requestMap = MessageUtil.parseXml(request);
			
			// 调用核心业务类接收消息、处理消息
			String respMessage = WechatBusiness.processRequest(shopNo,requestMap);
			// 响应消息
			PrintWriter out = response.getWriter();
			out.print(respMessage);
			out.close();
			//处理业务
			WechatBusiness.processRequestHandle(shopNo,requestMap);
			clock.stop();
			System.out.println("=====总用时："+clock.getTime()+"ms");
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
