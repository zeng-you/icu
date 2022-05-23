package com.icu.backstage.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author 曾有
 * @since 2022/5/23
 */
@Getter
@AllArgsConstructor
public enum CodeEnum {

    // 登录过期
    LOGIN_EXPIRED("登录过期，请重新登录" , 10000);

    /**
     * 提示信息
     */
    private final String msg;

    /**
     * 错误码
     */
    private final int code;



}
