package com.zjlp.face.shop.util.wechat;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.processors.PropertyNameProcessor;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.StopWatch;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.message.BasicNameValuePair;
import org.apache.log4j.Logger;

import com.zjlp.face.shop.domain.AccessToken;
import com.zjlp.face.shop.domain.GrandInfo;
import com.zjlp.face.shop.domain.WechatDevInfo;
import com.zjlp.face.shop.domain.WechatUserInfo;
import com.zjlp.face.shop.domain.templatemessage.Industry;
import com.zjlp.face.shop.domain.templatemessage.TemplateId;
import com.zjlp.face.shop.domain.templatemessage.TemplateMessage;
import com.zjlp.face.shop.domain.templatemessage.order.OrderStatus;
import com.zjlp.face.shop.util.JsonUtil;

public class WeiXinJzUtil {
	
	public static final String ACCESSTOKEN = "ACCESSTOKEN";
	
	private Logger _wechatInfoLog = Logger.getLogger("wechatInfoLog");
	
	private Logger _wechatErrorLog = Logger.getLogger("wechatErrorLog");
	
	// 主营行业（IT科技-互联网/电子商务）
	private static final String INDUSTRY_ID1 = "1";
	// 主营行业（消费品）
	private static final String INDUSTRY_ID2 = "31";
	// 消息模板ID(佣金提醒)
	private static final Integer COMMISSION_REMINDER = 3;
	// 会员卡领取通知
	private static final Integer MEMBERSHIP_CARD_NOTICE = 1;
	// 订单状态
	private static final Integer ORDER_STATUS = 2;
	// 佣金提醒编号
	private static final String COMMISSION_REMINDER_NO = "OPENTM201812627";
	// 会员卡领取通知编号
	private static final String MEMBERSHIP_CARD_NOTICE_NO = "OPENTM200964573";
	// 订单状态
	private static final String ORDER_STATUS_NO = "TM00017";
	
	private boolean isLogin = false;
	String token = "";
	// 随机码（43位）
	private static final String ENCODING_AESKEY = "SADUW5UqJ49Yv2cvb8GqN4adxcI7BY2J7A0SrMFSWsb";
	// 回调模式（0：明文模式 1：兼容模式 2：安全模式）
	private static final String CALLBACK_ENCRYPT_MODE = "0";
	// 操作序列
	private static final String OPERATION_SEQ = "201082865";
	// 微信登陆地址  
    public final static String LOGIN_URL = "https://mp.weixin.qq.com/cgi-bin/login?lang=zh_CN";
    // 微信主页
    public final static String INDEX_URL = "https://mp.weixin.qq.com/cgi-bin/home";
	// 开发者页面地址  
    public final static String DEV_URL = "https://mp.weixin.qq.com/advanced/advanced?action=dev&t=advanced/dev&lang=zh_CN&token=";
	// 服务器配置提交地址  
    public final static String DEV_SERVICE_URL = "https://mp.weixin.qq.com/advanced/callbackprofile?t=ajax-response&lang=zh_CN&token=";
    // 开发者编辑页面
    public final static String DEV_EDIT_URL = "https://mp.weixin.qq.com/advanced/advanced?action=edit&t=advanced/edit&lang=zh_CN&token=";
    // 切换开发模式  
    public final static String DEV_UPDATE_RUL = "https://mp.weixin.qq.com/misc/skeyform?form=advancedswitchform&lang=zh_CN";
    // 获取access_token的接口地址（GET） 限2000（次/天）  
 	public final static String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
 	// 创建菜单地址
 	public final static String MENU_CTEATE_URL = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";
 	// 查询菜单地址
 	public final static String MENU_GET_URL = "https://api.weixin.qq.com/cgi-bin/menu/get?access_token=ACCESS_TOKEN";
 	// 删除菜单地址
  	public final static String MENU_DELETE_URL = "https://api.weixin.qq.com/cgi-bin/menu/delete?access_token=ACCESS_TOKEN";
  	// 获取网页授权access_token地址
  	public final static String GRANT_ACCESS_TOKEN_URL = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=APPID&secret=SECRET&code=CODE&grant_type=authorization_code";
  	// 拉取用户信息(需scope为 snsapi_userinfo)
  	public final static String USER_INFO_URL = "https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
  	// 获取用户基本信息（包括UnionID机制）
  	public final static String USER_INFO_UNIONID_URL =	"https://api.weixin.qq.com/cgi-bin/user/info?access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN";
  	// 设置所属行业
  	public final static String INDUSTRY_URL = "https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN";
  	// 获得模板ID
  	private final static String TEMPLATE_ID_URL = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN";
  	// 发送模板消息
  	private final static String SEND_TEMPLATE_MESSAGE_URL = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN";
  	// 获取用户基本信息
  	private final static String GET_USER_BASE_INFO_URL = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=APPID&redirect_uri=REDIRECT_URI&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect";
  	// 生成二维码
  	private final static String CREATE_TWO_DIMENSIONAL_CODE_URL ="https://api.weixin.qq.com/cgi-bin/qrcode/create?access_token=TOKEN";
  	// 获取二维码
  	private final static String GET_TWO_DIMENSIONAL_CODE_URL = "https://mp.weixin.qq.com/cgi-bin/showqrcode?ticket=TICKET";
	
 	// 微信模拟登陆
	@SuppressWarnings("rawtypes")
	public Integer login(String username, String password) throws Exception {

		StopWatch clock = new StopWatch();
		clock.start(); // 计时开始
		
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("f", "json"));
		params.add(new BasicNameValuePair("imgcode", ""));
		params.add(new BasicNameValuePair("pwd", password));
		params.add(new BasicNameValuePair("username", username));
		HttpPost post = EnhancedHttpUtil.getPost(LOGIN_URL, params);
		post.setHeader("Referer", INDEX_URL);
		String html = EnhancedHttpUtil.getString(post);
		Map map = JsonUtil.readValue(html);
		Map base_resp = (Map) map.get("base_resp");
		if(StringUtils.isNotBlank(html)&&html.indexOf("&token=")!=-1){
			token = html.substring(html.indexOf("&token=") + "&token=".length(), html.indexOf("\"", html.indexOf("&token=")));
			isLogin = true;
			_wechatInfoLog.info("微信模拟登陆成功");
			
			clock.stop();
			_wechatInfoLog.info("======严重警告！！！该方法【微信登录】执行耗费:" + clock.getTime() + " ms ");
			
			return ((Integer)base_resp.get("ret")).intValue();
		}
		_wechatErrorLog.error("微信模拟登陆失败!username="+username+ ",password=" +password);
		if(((Integer) base_resp.get("ret")).intValue() == 0) {
			_wechatInfoLog.info("服务器配置提交成功");
		} else {
			_wechatErrorLog.error("服务器配置失败：！ret="+base_resp.get("ret")+",err_msg="+base_resp.get("err_msg"));
		}
		return ((Integer)base_resp.get("ret")).intValue();
		
	}
	
	//服务器配置提交
	@SuppressWarnings("rawtypes")
	public Integer setURL(String serverUrl, String callback_token)
			throws Exception {
		if (!this.isLogin) {
			_wechatErrorLog.error("服务器配置提交：未模拟登陆微信");
			return -1;
		}
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("url", serverUrl));
		params.add(new BasicNameValuePair("callback_token", callback_token));
		params.add(new BasicNameValuePair("encoding_aeskey", ENCODING_AESKEY));
		params.add(new BasicNameValuePair("callback_encrypt_mode", CALLBACK_ENCRYPT_MODE));
		params.add(new BasicNameValuePair("operation_seq", OPERATION_SEQ));
		HttpPost post = EnhancedHttpUtil.getPost(DEV_SERVICE_URL + this.token, params);
		post.setHeader("Referer", DEV_URL + this.token);
		String html = EnhancedHttpUtil.getString(post);
		Map map = JsonUtil.readValue(html);
		Map base_resp = (Map) map.get("base_resp");
		if(StringUtils.isBlank(html)) {
			_wechatErrorLog.error("服务器配置：发送请求失败！DEV_SERVICE_URL="+DEV_SERVICE_URL
					+this.token+",url="+serverUrl+",callback_token="+callback_token
					+",encoding_aeskey="+ENCODING_AESKEY+",callback_encrypt_mode="+CALLBACK_ENCRYPT_MODE
					+",operation_seq"+OPERATION_SEQ);
			return ((Integer) base_resp.get("ret")).intValue();
		}
		if(((Integer) base_resp.get("ret")).intValue() == 0) {
			_wechatInfoLog.info("服务器配置提交成功");
		} else {
			_wechatErrorLog.error("服务器配置失败：！ret="+base_resp.get("ret")+",err_msg="+base_resp.get("err_msg"));
		}
		return ((Integer) base_resp.get("ret")).intValue();
	}
	
	// 开启开发者模式
	@SuppressWarnings("rawtypes")
	public Integer setMode(String type, String flag) throws Exception {
		if (!this.isLogin) {
			_wechatErrorLog.error("服务器配置提交：未模拟登陆微信");
			return -1;
		}
		List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
		params.add(new BasicNameValuePair("flag", flag));
		params.add(new BasicNameValuePair("type", type));
		params.add(new BasicNameValuePair("token", this.token));
		HttpPost post = EnhancedHttpUtil.getPost(DEV_UPDATE_RUL, params);
		post.setHeader("Referer", DEV_EDIT_URL + this.token);
		String html = EnhancedHttpUtil.getString(post);
		Map map = JsonUtil.readValue(html);
		Map base_resp = (Map) map.get("base_resp");
		if(StringUtils.isBlank(html)) {
			_wechatErrorLog.error("开启开发者模式失败！DEV_EDIT_URL="+DEV_EDIT_URL
					+",token="+this.token+",flag="+flag+",type="+type);
			return ((Integer) base_resp.get("ret")).intValue();
		}
		if(((Integer) base_resp.get("ret")).intValue() == 0) {
			_wechatInfoLog.info("开启开发者模式成功");
		} else {
			_wechatErrorLog.error("开启开发者模式失败：！ret："+base_resp.get("ret"));
		}
		return ((Integer) base_resp.get("ret")).intValue();
	}
	
	// 获取微信通用接口凭证
	public AccessToken getAccessToken(String appId, String appSecret) {
		AccessToken accessToken = new AccessToken();
		String accessTokenUrl = ACCESS_TOKEN_URL.replace("APPID", appId).replace("APPSECRET", appSecret);
		HttpGet get = EnhancedHttpUtil.getGet(accessTokenUrl);
		get.setHeader("Referer", accessTokenUrl);
		String html = EnhancedHttpUtil.getString(get);
		JSONObject json = JSONObject.fromObject(html);
		if(null != json && null != json.get("access_token")) {
			accessToken.setToken(json.get("access_token").toString());
			accessToken.setExpiresIn(Integer.valueOf(json.get("expires_in").toString()));
			_wechatInfoLog.info("获取access token成功");
		} else if(null != json.get("errcode")) {
			accessToken.setErrcode(json.get("errcode").toString());
			_wechatErrorLog.error("获取access token失败：！errcode："+json.get("errcode")+",errmsg："+json.get("errmsg"));
		}
		return accessToken;
	}
	
	// 通过code换取网页授权access_token
	public GrandInfo getDynamicAccessoken(String code, WechatDevInfo devInfo) {
		String grantUrl = GRANT_ACCESS_TOKEN_URL.replace("APPID", devInfo.getAppId()).
				replace("SECRET", devInfo.getAppSecret()).replace("CODE", code);
		HttpGet get = EnhancedHttpUtil.getGet(grantUrl);
		String html = EnhancedHttpUtil.getString(get);
		if(StringUtils.isBlank(html)) {
			return null;
		}
		JSONObject grand = JSONObject.fromObject(html);
        if (null != grand && null != grand.get("errcode")) {  
            _wechatErrorLog.error("网页授权失败 errcode:{} errmsg:{}"+ grand.getInt("errcode")+ grand.getString("errmsg"));
            return null;
        }  
		GrandInfo grandInfo = new GrandInfo();
		grandInfo.setAccessToken(grand.getString("access_token"));
		grandInfo.setExpiresIn(Integer.valueOf(grand.getString("expires_in")));
		grandInfo.setOpenId(grand.getString("openid"));
		grandInfo.setRefreshToken(grand.getString("refresh_token"));
		grandInfo.setScope(grand.getString("scope"));
		return grandInfo;
	}
	// 拉取用户信息
	public WechatUserInfo getWechatUserInfo(GrandInfo grandInfo) {
		String userUrl = USER_INFO_URL.replace("ACCESS_TOKEN", grandInfo.getAccessToken()).
				replace("OPENID", grandInfo.getOpenId());
		HttpGet get = EnhancedHttpUtil.getGet(userUrl);
		String userInfo = EnhancedHttpUtil.getString(get);
		if(StringUtils.isBlank(userInfo)) {
			return null;
		}
		JSONObject user = JSONObject.fromObject(userInfo);
		if (null != user) {  
	        if ("40001".equals(user.get("errcode"))) {  
	            _wechatErrorLog.error("网页授权失败 errcode:{} errmsg:{}"+ user.getInt("errcode")+ user.getString("errmsg"));
	            return null ;
	        }  
	    }
		WechatUserInfo wechatUserInfo = new WechatUserInfo();
		wechatUserInfo.setOpenId(user.getString("openid"));
		return wechatUserInfo;
	}
	
	// 拉取用户信息
	public WechatUserInfo getWechatUserUnionIDInfo(GrandInfo grandInfo) {
		String userUrl = USER_INFO_UNIONID_URL.replace("ACCESS_TOKEN", grandInfo.getAccessToken()).
				replace("OPENID", grandInfo.getOpenId());
		HttpGet get = EnhancedHttpUtil.getGet(userUrl);
		String userInfo = EnhancedHttpUtil.getString(get);
		if(StringUtils.isBlank(userInfo)) {
			return null;
		}
		JSONObject user = JSONObject.fromObject(userInfo);
		if (null != user) {  
	        if ("40001".equals(user.get("errcode"))) {  
	            _wechatErrorLog.error("网页授权失败 errcode:{} errmsg:{}"+ user.getInt("errcode")+ user.getString("errmsg"));
	            return null ;
	        }  
	    }
		WechatUserInfo wechatUserInfo = new WechatUserInfo();
		wechatUserInfo.setOpenId(user.getString("openid"));
		wechatUserInfo.setNickname(user.getString("nickname"));
		wechatUserInfo.setSex(user.getInt("sex"));
		wechatUserInfo.setCity(user.getString("city"));
		wechatUserInfo.setCountry(user.getString("country"));
		wechatUserInfo.setProvince(user.getString("province"));
		wechatUserInfo.setHeadimgurl(user.getString("headimgurl"));
		return wechatUserInfo;
	}
	
	// 设置所属行业
	public Integer setIndustry(String accessToken) {
		Industry industry = new Industry();
		industry.setIndustry_id1(INDUSTRY_ID1);
		industry.setIndustry_id2(INDUSTRY_ID2);
		String industryJson = JSONObject.fromObject(industry).toString();
		String industryUrl = INDUSTRY_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost post = EnhancedHttpUtil.getPost(industryUrl, industryJson);
		String result = EnhancedHttpUtil.getString(post);
		JSONObject json = JSONObject.fromObject(result);
		if(null != json && "0".equals(json.getString("errcode"))) {
			_wechatInfoLog.info("设置模板消息所属行业成功");
			return Integer.valueOf(json.getString("errcode"));
		} else if(null != json.get("errcode")) {
			_wechatErrorLog.error("设置模板消息所属行业失败：！errcode："+json.get("errcode")+",errmsg："+json.get("errmsg"));
			return Integer.valueOf(json.getString("errcode"));
		}
		return -1;
	}
	
	// 获得模板ID
	public String getTemplateId(TemplateId templateId, String accessToken) {
		
		String industryJson = JSONObject.fromObject(templateId).toString();
		String industryUrl = TEMPLATE_ID_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost post = EnhancedHttpUtil.getPost(industryUrl, industryJson);
		String result = EnhancedHttpUtil.getString(post);
		JSONObject json = JSONObject.fromObject(result);
		if(null != json && ("0").equals(json.getString("errcode"))) {
			_wechatInfoLog.info("获取模板消息所属行业模板ID成功");
			return json.getString("template_id");
		} else if(!("0").equals(json.get("errcode"))) {
			_wechatErrorLog.error("获取模板消息所属行业模板ID失败：！errcode："+json.get("errcode")+",errmsg："+json.get("errmsg"));
		}
		return null;
	}
	
	// 发送模板消息
	public Integer sendTemplateMessage(TemplateMessage templateMessage, String accessToken) {
		
		JsonConfig config = new JsonConfig();
		/**
		 * 字段重命名
		 * java--->json修改字段名字的时候使用jsonConfig.registerJsonPropertyNameProcessor
		 * json--->java的时候使用jsonConfig.registerJavaPropertyNameProcessor
		 */
		config.registerJsonPropertyNameProcessor(OrderStatus.class, new PropertyNameProcessor() {
			@SuppressWarnings("rawtypes")
			@Override
			public String processPropertyName(Class clazz, String name) {
				if (name.equalsIgnoreCase("orderSn")) {
					return "OrderSn";
				}else if (name.equalsIgnoreCase("orderStatus")) {
					return "OrderStatus";
				}
				return name;
			}
		});
		String templateMessageJson = JSONObject.fromObject(templateMessage,config).toString();
		String templateMessageUrl = SEND_TEMPLATE_MESSAGE_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost post = EnhancedHttpUtil.getPost(templateMessageUrl, templateMessageJson);
		String result = EnhancedHttpUtil.getString(post);
		JSONObject json = JSONObject.fromObject(result);
		if(null != json && ("0").equals(json.getString("errcode"))) {
			_wechatInfoLog.info("发送模板消息成功");
			return Integer.valueOf(json.getString("errcode"));
		} else if(null != json.get("errcode")) {
			_wechatErrorLog.error("发送模板消息失败：！errcode："+json.get("errcode")+",errmsg："+json.get("errmsg"));
		}
		return -1;
	}
	
	
	// 获取模板编号
	public TemplateId _getTemplateNo(Integer type) {
		
		TemplateId templateId = new TemplateId();
		// 佣金提醒模板消息
		if(COMMISSION_REMINDER.equals(type)) {
			templateId.setTemplate_id_short(COMMISSION_REMINDER_NO);
		// 会员卡领取通知模板消息
		} else if(MEMBERSHIP_CARD_NOTICE.equals(type)) {
			templateId.setTemplate_id_short(MEMBERSHIP_CARD_NOTICE_NO);
		// 订单状态更新模板消息
		} else if(ORDER_STATUS.equals(type)) {
			templateId.setTemplate_id_short(ORDER_STATUS_NO);
		}
		return templateId;
	}
	
	// 获取fakeid
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public String getFakeid(String nickName, String openid) throws IOException {
		if (!this.isLogin) {
			throw new RuntimeException("no login");
		}
		HttpGet get = EnhancedHttpUtil.getGet("https://mp.weixin.qq.com/cgi-bin/contactmanage?t=user/index&lang=zh_CN&pagesize=10&pageidx=0&type=0&groupid=0&token="
				+ this.token);
		get.setHeader("Referer", "https://mp.weixin.qq.com/cgi-bin");
		String html = EnhancedHttpUtil.getString(get);
		String userjson = substringBetween(html, "friendsList : (",
				").contacts");
		Map map = JsonUtil.readValue(userjson);

		List<Map> contacts = (List<Map>) map.get("contacts");
		for (Map m : contacts) {
			Object ob = m.get("id");
			Object nick_name = m.get("nick_name");
			String fid = "";
			String name = "";
			if (ob != null) {
				fid = ob.toString();
			}
			if(StringUtils.isNotBlank(fid) && null != nick_name) {
				name = nick_name.toString();
				if(name.equals(nickName)) {
					return fid;
				}
			}
		}
		return null;
	}
	
	// 创建二维码ticket
	@SuppressWarnings("static-access")
	public String createTwoDimensionalCode(String shopNo, String accessToken) {
		//需要提交的JSON数据
		String jsonMsg = "{\"action_name\": \"QR_LIMIT_STR_SCENE\", \"action_info\": {\"scene\": {\"scene_str\": \"%s\"}}}";
		jsonMsg = jsonMsg.format(jsonMsg, shopNo);
		String createTwoDimensionalCodeUrl = CREATE_TWO_DIMENSIONAL_CODE_URL.replace("TOKEN", accessToken);
		HttpPost post = EnhancedHttpUtil.getPost(createTwoDimensionalCodeUrl, jsonMsg);
		String result = EnhancedHttpUtil.getString(post);
		JSONObject json = JSONObject.fromObject(result);
		if(null != json && json.toString().indexOf("errcode") < 0) {
			_wechatInfoLog.info("创建二维码成功");
			return json.getString("ticket");
		} else if(null != json.get("errcode")) {
			_wechatErrorLog.error("创建二维码失败：！errcode："+json.get("errcode")+",errmsg："+json.get("errmsg"));
		}
		
		return "";
	}
	
	// 获取二维码
	public byte[] getTwoDimensionalCode(String ticket) throws IOException {
		String getTwoDimensionalCodeUrl = GET_TWO_DIMENSIONAL_CODE_URL.replace("TICKET", urlEnodeUTF8(ticket));
		URL url = new URL(getTwoDimensionalCodeUrl);
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		return input2byte(connection.getInputStream());
	}
	
	// 创建菜单
	public int createMenu(String menu, String accessToken) {
		int result = 0;
		// 拼装创建菜单地址
		String menuUrl = MENU_CTEATE_URL.replace("ACCESS_TOKEN", accessToken);
		// 将菜单对象转换为json
		_wechatInfoLog.info("创建菜单 json:"+ menu);
		System.out.println(menu);
		HttpPost post = EnhancedHttpUtil.getPost(menuUrl,menu);
		String html = EnhancedHttpUtil.getString(post);
		JSONObject rt = JSONObject.fromObject(html);
		if (null != rt) {  
	        if (0 != rt.getInt("errcode")) {  
	            result = rt.getInt("errcode");  
	            _wechatErrorLog.error("创建菜单失败 errcode:{} errmsg:{}"+ rt.getInt("errcode")+ rt.getString("errmsg"));;  
	        }  
	    }
		return result;
	}
	
	private String substringBetween(String src, String begin, String end) {
		if ((src == null) || ("".equals(src))) {
			return "";
		}
		int b = src.indexOf(begin);
		if (b == -1) {
			return "";
		}
		b += begin.length();
		int e = src.indexOf(end, b);
		if (e == -1) {
			return src.substring(b);
		}
		return src.substring(b, e);
	}
	
	/**
	 * 获取基本权限URL
	 * @Title: getoauth2Url 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @return
	 * @date 2015年3月11日 下午1:33:52  
	 * @author ah
	 */
	public static String getoauth2Url(String appId, String path, String url) {
		String userBaseInfoUrl = GET_USER_BASE_INFO_URL.replace("APPID", appId).replace("REDIRECT_URI", urlEnodeUTF8(path)).replace("STATE", urlEnodeUTF8(url));
		return userBaseInfoUrl;
	}
	
	/**
	 * 把网址里的特殊字符转换，如http://转换成http:%3A%2F%2F
	 * @Title: urlEnodeUTF8 
	 * @Description: (这里用一句话描述这个方法的作用) 
	 * @param str
	 * @return
	 * @date 2015年2月3日 下午4:17:46  
	 * @author liujia
	 */
    public static String urlEnodeUTF8(String str){
        String result = str;
        try {
            result = URLEncoder.encode(str,"UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
	
    public static final byte[] input2byte(InputStream inStream)  
            throws IOException {  
        ByteArrayOutputStream swapStream = new ByteArrayOutputStream();  
        byte[] buff = new byte[100];  
        int rc = 0;  
        while ((rc = inStream.read(buff, 0, 100)) > 0) {  
            swapStream.write(buff, 0, rc);  
        }  
        byte[] in2b = swapStream.toByteArray();  
        return in2b;  
    }
    
	public static void main(String[] args) {
		ArrayList<String> paramList = new ArrayList<String>();
		paramList.add("您的订单状态已更新");
		paramList.add("23423525321");
		paramList.add("已发货");
		paramList.add("请进入店铺查看详情。");
		WeiXinJzUtil wt = new WeiXinJzUtil();
		
		try {
			wt.createTwoDimensionalCode("9999", "h2yuNHLQNckX4unLtH9WI_Xo2EaRXu0DNNu2cHErYpCj8f5EKFJ-W-R2S194Ef5MHvuiezCRwCQd5dpYfmCIbF3aQZ5-cx5ryojxq-tFfKo");
//			wt.getTwoDimensionalCode("gQGA8DoAAAAAAAAAASxodHRwOi8vd2VpeGluLnFxLmNvbS9xL0hVT2dXanJtODY2S0lWN3p1V19aAAIEvgU_VQMEAAAAAA==");
//			wt.setIndustry("q300Rl_ZYyK-N6hw2y34nUFaBnQPMxetszJwuWdSoW6oDlDoFgGlFDW1mOnJbcK6HSvKWglpG0EfWCuYgG6z1L5itCMESQsYNIEICLeK9V8");
//			wt.getAccessToken("", "");
//			wt.sendTemplateMessage("oVkjjt7Du4PgNU7JIxDxOYSm_LZ4", paramList, OrderStatus.class, "Un8UiDor64XNK828lft6sOs2Dlw-IlSodO_tb0aKczJjmFwLKQRtKOAJ7L4-SPMmiqLYH-Ts5M27gN42tpqC7M6Xs8flH4mHSwcUwQA_Yek", null);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
