package com.icu.backstage.config;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.alibaba.fastjson2.JSON;
import com.icu.common.tool.enums.CodeEnum;
import com.icu.common.tool.util.E;
import com.icu.common.tool.util.R;
import lombok.extern.log4j.Log4j2;
import org.jetbrains.annotations.NotNull;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Objects;

/**
 * 全局结果集处理
 *
 * @author 曾有
 * @since 2022/5/22
 */
@Log4j2
@RestControllerAdvice
public class ResponseBodyAdviceConfig implements ResponseBodyAdvice<Object> {

    /**
     * 异常
     */
    @ExceptionHandler
    public R<Object> handlerException(Exception e) {

        e.printStackTrace();

        R<Object> r;

        if (e instanceof E ee) {
            // 自定义
            r = R.failed(e.getMessage(), ee.getCode());
        } else if (e instanceof NotLoginException) {
            // 未登录
            r = R.failed(CodeEnum.LOGIN_EXPIRED.getMsg(), CodeEnum.LOGIN_EXPIRED.getCode());
        } else if (e instanceof NotRoleException ee) {
            // 角色
            r = R.failed("无此角色：" + ee.getRole(), ee.getCode());
        } else if (e instanceof NotPermissionException ee) {
            // 权限
            r = R.failed("无此权限：" + ee.getPermission());
        } else if (e instanceof DisableLoginException ee) {
            // 被封禁
            r = R.failed("账号被封禁：" + ee.getDisableTime() + "秒后解封", ee.getCode());
        } else {
            // 其它
            r = R.failed(e.getMessage());
        }

        return r;
    }

    /**
     * 判断是否要执行beforeBodyWrite方法，true为执行，false不执行
     */
    @Override
    public boolean supports(@NotNull MethodParameter returnType, @NotNull Class<? extends HttpMessageConverter<?>> converterType) {
        return !Objects.requireNonNull(returnType.getMethod()).getReturnType().isAssignableFrom(Void.TYPE);
    }

    /**
     * 结果集处理
     */
    @Override
    public Object beforeBodyWrite(Object body, @NotNull MethodParameter returnType, @NotNull MediaType selectedContentType, @NotNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NotNull ServerHttpRequest request, @NotNull ServerHttpResponse response) {

        if (body instanceof R) {
            return body;
        }

        R<Object> r = R.ok(body);

        return returnType.getParameterType().isAssignableFrom(String.class) ? JSON.toJSONString(R.ok(r)) : r;
    }
}
