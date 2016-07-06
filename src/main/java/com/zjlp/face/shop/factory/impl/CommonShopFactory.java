package com.zjlp.face.shop.factory.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zjlp.face.account.service.AccountService;
import com.zjlp.face.shop.domain.Member;
import com.zjlp.face.shop.domain.MemberEnactment;
import com.zjlp.face.shop.domain.Shop;
import com.zjlp.face.shop.domain.ShopRoleRelation;
import com.zjlp.face.shop.domain.ToolSetting;
import com.zjlp.face.shop.domain.User;
import com.zjlp.face.shop.dto.ShopDto;
import com.zjlp.face.shop.exception.ShopException;
import com.zjlp.face.shop.exception.enums.ShopExceptionEnum;
import com.zjlp.face.shop.factory.ShopFactory;
import com.zjlp.face.shop.service.MemberEnactmentService;
import com.zjlp.face.shop.service.MemberService;
import com.zjlp.face.shop.service.ShopRoleRelationService;
import com.zjlp.face.shop.service.ShopService;
import com.zjlp.face.shop.service.ToolSettingService;
import com.zjlp.face.shop.service.UserService;
import com.zjlp.face.shop.util.AssertUtil;
import com.zjlp.face.shop.util.ConstantsUtil;
import com.zjlp.face.shop.util.GenerateCode;
import com.zjlp.face.web.server.product.template.service.OwTemplateService;

/**
 * 普通店铺生产
 * @ClassName: CommonShopFactory 
 * @Description: (普通店铺生产) 
 * @author ah
 * @date 2015年1月5日 下午2:29:48
 */
@Service("commonShopFactory")
public class CommonShopFactory implements ShopFactory {

	@Autowired
    private ShopService shopService;

    @Autowired
    private UserService userService;

    @Autowired
    private ShopRoleRelationService shopRoleRelationService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private MemberEnactmentService memberEnactmentService;

    @Autowired
    private ToolSettingService toolSettingService;

	// 平台用户
    private static final Integer USER_TYPE_PF = 9;

    // 全部行业(微平台)
    private static final Long GOOD_CLASSIFICATION_TYPE = Long.valueOf(9);

    // 模板服务
    @Autowired(required = false)
    private OwTemplateService owTemplateService;

    @Autowired(required = false)
    private AccountService accountService;
    
    private Logger _shopInfoLog = Logger.getLogger("shopInfoLog");
    
    private Logger _shopErrorLog = Logger.getLogger("shopErrorLog");
    
	@Override
	public Shop addShop(ShopDto shopDto) throws ShopException {
		Date date = new Date();
        Integer type = shopDto.getType();
        try{
            // 1.查询注册用户
        	_shopInfoLog.info("新增普通店铺开始！");
            User user = userService.getUserByLoginAccount(shopDto.getLoginAccount());
            _shopInfoLog.info("用户的登陆账号："+shopDto.getLoginAccount());
            AssertUtil.notNull(user, ShopException.class, ShopExceptionEnum.SHOP_10001);
            // 1.1普通用户不能添加平台产品
            AssertUtil.isTrue((ConstantsUtil.CLASSIFICATION_PF.equals(type) && !USER_TYPE_PF.equals(user.getType())), ShopException.class, ShopExceptionEnum.SHOP_10002);
            // 1.2平台用户请选择微平台
            AssertUtil.isTrue((!ConstantsUtil.CLASSIFICATION_PF.equals(type) && USER_TYPE_PF.equals(user.getType())), ShopException.class, ShopExceptionEnum.SHOP_10003);
            // 1.3平台用户时所属行业请选择全部行业
            AssertUtil.isTrue((!GOOD_CLASSIFICATION_TYPE.equals(shopDto.getClassificationId()) && USER_TYPE_PF.equals(user.getType())), ShopException.class, ShopExceptionEnum.SHOP_10004);
            // 1.4普通用户时所属行业不能选择全部行业
//            AssertUtil.isTrue((GOOD_CLASSIFICATION_TYPE.equals(shopDto.getClassificationId()) && !USER_TYPE_PF.equals(user.getType())), ShopException.class, ShopExceptionEnum.SHOP_10005);
            // 2.邀请码验证
            if(StringUtils.isNotBlank(shopDto.getOnInvitationCode())){
                Shop s = shopService.getShopByInvitationCode(shopDto.getOnInvitationCode());
                _shopInfoLog.info("店铺的上家邀请码："+shopDto.getOnInvitationCode());
                AssertUtil.notNull(s, ShopException.class, ShopExceptionEnum.SHOP_00005);
            }
            // 3.新增产品
            // 生成产品编号
            String no = GenerateCode.generateShopNo(type);
            AssertUtil.notNull(no, ShopException.class, ShopExceptionEnum.SHOP_00004);
            Shop shop = Shop._generateShop(no, user, shopDto);
            _shopInfoLog.info("店铺详情："+shop);
            shopService.addShop(shop);
            // 4.添加权限
            ShopRoleRelation shopRoleRelation = ShopRoleRelation._generateRole(no, type);
            shopRoleRelationService.addShopRoleRelation(shopRoleRelation);
            AssertUtil.notNull(shopRoleRelation.getId(), ShopException.class, ShopExceptionEnum.SHOP_30001);
            // 5.会员初始化
            // 查看用户是否已有会员信息
            MemberEnactment m = memberEnactmentService.getByUserId(user.getId());
            if(null == m){
                // 会员规则数据初始化
                List<Member> members = Member.initMembers(user.getId(), date);
                for(Member member : members){
                    memberService.addMember(member);
                    AssertUtil.notNull(member.getId(), ShopException.class, ShopExceptionEnum.SHOP_60001);
                }
                // 会员设定数据初始化
                MemberEnactment memberEnactment = MemberEnactment.initMemberEnactment(user.getId(), date);
                memberEnactmentService.addMemberEnactment(memberEnactment);
                AssertUtil.notNull(memberEnactment.getId(), ShopException.class, ShopExceptionEnum.SHOP_60002);
            }
            // 6.产品钱包
            accountService.addAccount(shop.getNo(), shop.getCell(), null, null, null);
            // 7.微信自动回复设置数据初始化
            ToolSetting toolSetting = ToolSetting.initToolSetting(shop.getNo(), date);
            toolSettingService.addToolSetting(toolSetting);
            AssertUtil.notNull(toolSetting.getId(), ShopException.class, ShopExceptionEnum.SHOP_80002);
            // 8.调用模板服务，初始化数据
            if(!ConstantsUtil.CLASSIFICATION_PF.equals(type)){
            	owTemplateService.initTemplate(no, type);
            }
            
            _shopInfoLog.info("新增普通店铺结束！");
            return shop;
        }catch(ShopException e){
        	_shopErrorLog.error(e.getMessage());
            throw e;
        }catch(Exception e){
        	_shopErrorLog.error(e.getMessage());
            throw new ShopException(e);
        }
	}
}
