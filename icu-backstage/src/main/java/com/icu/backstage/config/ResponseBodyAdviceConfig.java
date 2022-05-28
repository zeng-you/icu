package com.icu.backstage.config;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import cn.hutool.core.collection.CollStreamUtil;
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
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Map;
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
     * 自定义异常
     */
    @ExceptionHandler(value = E.class)
    public R<Object> exceptionHandle(E e) {
        return R.failed(e.getMessage(), e.getCode());
    }

    /**
     * 未登录异常
     */
    @ExceptionHandler(value = NotLoginException.class)
    public R<Object> exceptionHandle() {
        return R.failed(CodeEnum.LOGIN_EXPIRED.getMsg(), CodeEnum.LOGIN_EXPIRED.getCode());
    }

    /**
     * 角色异常
     */
    @ExceptionHandler(value = NotRoleException.class)
    public R<Object> exceptionHandle(NotRoleException e) {
        return R.failed("无此角色：" + e.getRole(), e.getCode());
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(value = NotPermissionException.class)
    public R<Object> exceptionHandle(NotPermissionException e) {
        return R.failed("无此权限：" + e.getPermission());
    }

    /**
     * 被封禁异常
     */
    @ExceptionHandler(value = DisableLoginException.class)
    public R<Object> exceptionHandle(DisableLoginException e) {
        return R.failed("账号被封禁：" + e.getDisableTime() + "秒后解封", e.getCode());
    }

    /**
     * 其它异常
     */
    @ExceptionHandler(value = Exception.class)
    public R<Object> exceptionHandle(Exception e) {
        return R.failed(e.getMessage());
    }

    /**
     * 参数错误异常
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R<Object> exceptionHandle(MethodArgumentNotValidException e) {

        BindingResult bindingResult = e.getBindingResult();

        List<FieldError> fieldError = bindingResult.getFieldErrors();

        Map<String, Object> msg = CollStreamUtil.toMap(fieldError, FieldError::getField, FieldError::getDefaultMessage);

        return R.failed(msg, CodeEnum.VALIDATED_METHOD.getCode(), CodeEnum.VALIDATED_METHOD.getMsg());
    }
    
    /**
     * 参数错误异常（待完善）
     */
    @ExceptionHandler(value = BindException.class)
    public R<Object> exceptionHandle(BindException e) {
        return R.failed(e.getMessage(), 2222);
    }

    /**
     * 参数错误异常（待完善）
     */
    @ExceptionHandler(value = ConstraintViolationException.class)
    public R<Object> exceptionHandle(ConstraintViolationException e) {
        return R.failed(e.getMessage(), 3333);
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
