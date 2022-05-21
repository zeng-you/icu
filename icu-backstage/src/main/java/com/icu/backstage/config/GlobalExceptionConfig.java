package com.icu.backstage.config;

import cn.dev33.satoken.exception.DisableLoginException;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.exception.NotPermissionException;
import cn.dev33.satoken.exception.NotRoleException;
import com.icu.common.tool.util.R;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局异常处理
 *
 * @author 曾有
 * @since 2022/5/21
 */
@ControllerAdvice
public class GlobalExceptionConfig {

    // 全局异常拦截（拦截项目中的所有异常）
    @ResponseBody
    @ExceptionHandler
    public R<Object> handlerException(Exception e, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        // 打印堆栈，以供调试
        System.out.println("全局异常---------------");
        e.printStackTrace();

        // 不同异常返回不同状态码
        R<Object> aj;

        if (e instanceof NotLoginException ee) {
            // 未登录
            aj = R.failed(ee.getMessage());
        } else if (e instanceof NotRoleException ee) {
            // 角色
            aj = R.failed("无此角色：" + ee.getRole());
        } else if (e instanceof NotPermissionException ee) {
            // 权限
            aj = R.failed("无此权限：" + ee.getPermission());
        } else if (e instanceof DisableLoginException ee) {
            // 被封禁
            aj = R.failed("账号被封禁：" + ee.getDisableTime() + "秒后解封");
        } else {
            // 普通异常
            aj = R.failed(e.getMessage());
        }


        return aj;
    }

}
