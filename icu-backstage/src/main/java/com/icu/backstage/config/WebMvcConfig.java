package com.icu.backstage.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 曾有
 * @since 2022/5/23
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 注册Sa-Token的拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册路由拦截器，自定义认证规则
        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {

            // 登录认证 -- 拦截所有路由
            SaRouter.match("/**", r -> StpUtil.checkLogin());

            // 权限认证 -- 不同模块认证不同权限
            SaRouter.match("/admin/**", r -> StpUtil.checkPermission("admin"));
            SaRouter.match("/menu/**", r -> StpUtil.checkPermission("menu"));

        })).addPathPatterns("/**").excludePathPatterns("/admin/login");
    }
}
