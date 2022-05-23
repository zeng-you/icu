package com.icu.common.tool.util;

import lombok.Getter;

import java.io.Serial;

/**
 * @author 曾有
 * @since 2022/5/23
 */
public class E extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    @Getter
    private int code;

    /**
     * 提示信息
     */
    public E(String msg) {
        super(msg);
    }

    /**
     * 提示信息和状态码
     */
    public E(String msg, int code) {
        super(msg);
        this.code = code;
    }

}
