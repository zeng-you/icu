package com.icu.backstage.config.satoken.at;

import cn.dev33.satoken.exception.SaTokenException;
import cn.dev33.satoken.jwt.SaJwtUtil;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;

import java.util.Map;

/**
 * Sa-Token 整合 jwt -- Simple 简单模式
 *
 * @author 曾有
 * @since 2022/5/26
 */
public class StpAdminLogicJwtForSimple extends StpLogic {

    /**
     * Sa-Token 整合 jwt -- Simple模式 
     */
    public StpAdminLogicJwtForSimple() {
        super(StpUtil.TYPE);
    }

    /**
     * Sa-Token 整合 jwt -- Simple模式 
     * @param loginType 账号体系标识 
     */
    public StpAdminLogicJwtForSimple(String loginType) {
        super(loginType);
    }

    /**
     * 获取jwt秘钥 
     * @return / 
     */
    public String jwtSecretKey() {
        String keyt = getConfig().getJwtSecretKey();
        SaTokenException.throwByNull(keyt, "请配置jwt秘钥");
        return keyt;
    }

    // ------ 重写方法 

    /**
     * 创建一个TokenValue
     */
    @Override
    public String createTokenValue(Object loginId, String device, long timeout, Map<String, Object> extraData) {
        return SaJwtUtil.createToken(loginType, loginId, extraData, jwtSecretKey());
    }

    /**
     * 获取Token携带的扩展信息
     */
    @Override
    public Object getExtra(String key) {
        return SaJwtUtil.getPayloadsNotCheck(getTokenValue(), loginType, jwtSecretKey()).get(key);
    }

}
