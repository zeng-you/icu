package com.icu.backstage.config.satoken;

import cn.dev33.satoken.jwt.StpLogicJwtForSimple;
import cn.dev33.satoken.stp.StpLogic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sa-Token 集成 jwt
 * @author 曾有
 * @since 2022/5/25
 */
@Configuration
public class SaTokenConfig {

    /**
     * Simple 简单模式
     */
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForSimple();
    }

}
