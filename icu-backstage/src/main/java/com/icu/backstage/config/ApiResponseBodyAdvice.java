package com.icu.backstage.config;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.icu.common.tool.util.R;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 曾有
 * @since 2022/5/22
 */
@Log4j2
@RestControllerAdvice
public class ApiResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    public ApiResponseBodyAdvice() {
    }

    public boolean supports(MethodParameter returnType, Class converterType) {
        return !returnType.getMethod().getReturnType().isAssignableFrom(Void.TYPE);
    }

    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {

        log.info("全局结果集返回");

        if (body instanceof R) {
            return body;
        } else {
            R apiResult = R.ok(body);
            return returnType.getParameterType().isAssignableFrom(String.class) ? R.ok(apiResult) : apiResult;
        }
    }

    // 全局异常拦截（拦截项目中的所有异常）
    @ExceptionHandler
    public R<Object> handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 打印堆栈，以供调试
        log.info("-------全局异常--------");

        e.printStackTrace();

        // 不同异常返回不同状态码
        R<Object> r;

        if (e instanceof NotLoginException ee) {
            // 未登录
            r = R.failed(ee.getMessage(), ee.getCode());
        } else if (e instanceof NotRoleException ee) {
            // 角色
            r = R.failed("无此角色：" + ee.getRole(), ee.getCode());
        } else if (e instanceof NotPermissionException ee) {
            // 权限
            r = R.failed("无此权限：" + ee.getPermission(), ee.getPermission());
        } else if (e instanceof DisableLoginException ee) {
            // 被封禁
            r = R.failed("账号被封禁：" + ee.getDisableTime() + "秒后解封", ee.getCode());
        } else {
            // 普通异常
            r = R.failed(e.getMessage());
        }

        return r;
    }


}
