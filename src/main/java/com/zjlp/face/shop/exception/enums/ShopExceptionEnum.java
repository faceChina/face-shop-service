package com.zjlp.face.shop.exception.enums;

/**
 * 产品错误列表
 * @ClassName: UserExceptionEnum 
 * @Description: (产品错误列表) 
 * @author ah
 * @date 2014年7月17日 下午2:14:21
 */
public enum ShopExceptionEnum implements BaseExceptionEnum {
	/** 新增产品失败 */
	SHOP_00001("新增产品失败", "新增产品失败", null),
	/** 编辑产品失败 */
	SHOP_00002("编辑产品失败", "编辑产品失败", null),
	/** 查询产品列表失败 */
	SHOP_00003("查询产品列表失败", "查询产品失败", null),
	/** 生成产品编号失败 */
	SHOP_00004("生成产品编号失败", "请补充完整用户信息！", null),
	/** 查询产品失败 */
	SHOP_00005("查询的产品为空", "请输入正确的来源信息！", null),
	/** 查询用户失败 */
	SHOP_10001("查询用户失败", "用户不存在！", null),
	/** 普通用户不能添加平台产品 */
	SHOP_10002("普通用户不能添加微平台", "普通用户不能添加微平台！", null),
	/** 平台用户请选择微平台 */
	SHOP_10003("平台用户请选择微平台", "平台用户请选择微平台！", null),
	/** 平台用户时所属行业请选择全部行业 */
	SHOP_10004("平台用户时所属行业请选择全部行业", "平台用户时所属行业请选择全部行业！", null),
	/** 普通用户时所属行业不能选择全部行业 */
	SHOP_10005("普通用户时所属行业不能选择全部行业", "普通用户时所属行业不能选择全部行业！", null),
	/** 查询默认银行卡失败 */
	SHOP_20001("查询默认银行卡失败", "请给用户设置默认银行卡！", null),
	/** 添加权限失败 */
	SHOP_30001("添加权限失败", "新增产品失败！", null),
	/** 新增产品与分类关联失败 */
	SHOP_40001("新增产品与分类关联关系失败", "新增产品失败！", null),
	/** 新增产品与银行卡关联关系失败 */
	SHOP_50001("新增产品与银行卡关联关系失败", "新增产品失败！", null),
	/** 新增会员规则失败 */
	SHOP_60001("新增会员规则失败", "新增产品失败！", null),
	/** 新增会员设定失败 */
	SHOP_60002("新增会员设定失败", "新增产品失败！", null),
	/** 新增钱包失败 */
	SHOP_70001("新增钱包失败", "新增产品失败！", null),
	/** 新增通信方式设定失败 */
	SHOP_80002("新增通信方式设定设定失败", "新增产品失败！", null),
	/** 微信号已绑定 */
	SHOP_90001("微信号已绑定", "该微信号已绑定,请绑定其他微信号！", null),
	/** 加密失败 */
	SHOP_90002("链接微信服务器失败，账号密码错误或微信服务器故障!", "账号密码错误或微信服务器故障!", null),
	/** 绑定商户设置微信url失败 */
	SHOP_90003("网络连接失败，请稍后再试!", "网络连接失败，请稍后再试!", null),
	/** 开启开发者模式失败 */
	SHOP_90004("开启开发者模式失败!", "微信公众平台端，开启开发者模式失败!", null),
	/** 微信公众账号或密码错误 */
	SHOP_90005("微信公众账号或密码错误!", "您输入的帐号或者密码不正确，请重新输入。", null),
	/** 密码输入错误次数过多，验证码读取不到 */
	SHOP_90006("微信公众账号或密码错误!", "您输入的密码输入错误次数过多，请稍后再进行绑定。", null),
	/** 微信公众平台内公众号设置内帐号信息不全 */
	SHOP_90007("微信公众账号或密码错误!", "请前往微信公众平台的公众号设置补充完整帐号信息。", null),
	/** 该微信帐号不存在，请输入正确的微信号 */
	SHOP_90008("该微信帐号不存在，请输入正确的微信号!", "该微信帐号不存在，请输入正确的微信号。", null),
	/** 获取access_token时AppSecret错误 */
	SHOP_90009("获取access_token时AppSecret错误!", "请用户认真比对AppSecret的正确性。", null),
	/** 不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写 */
	SHOP_90010("不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写!", "不合法的AppID，请开发者检查AppID的正确性，避免异常字符，注意大小写。", null),
	/** 模板消息设置所属行业失败 */
	SHOP_90011("模板消息设置所属行业失败!", "模板消息设置所属行业失败。", null),
	/** 获取access_token时错误 */
	SHOP_90012("获取access_token时错误!", "请用户认真比对AppID,AppSecret的正确性,并确保此公众号已经认证。", null),
	;

	//内部信息
	private String innerMsg;
	//外部信息
	private String externalMsg;
	//返回的错误页面
	private ErrorPageEnum errorPage;
	
	private ShopExceptionEnum(String arg1, String arg2, ErrorPageEnum arg3) {
		innerMsg = arg1;
		externalMsg = arg2;
		errorPage = arg3;
	}
	
	@Override
	public String getErrCode() {
		return name();
	}

	@Override
	public String getInnerMsg() {
		return innerMsg;
	}

	@Override
	public String getExternalMsg() {
		return externalMsg;
	}

	@Override
	public String getErrPage() {
		return errorPage.getErrPageUrl();
	}

}
