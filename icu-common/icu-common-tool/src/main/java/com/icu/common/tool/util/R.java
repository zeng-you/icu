package com.icu.common.tool.util;

import lombok.*;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * 响应
 * @author 曾有
 * @since 2022/5/12
 */
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class R<T> implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码（0：成功，1：失败）
     */
    @Getter
    @Setter
    private int code;

    /**
     * 提示信息
     */
    @Getter
    @Setter
    private String msg;

    /**
     * 数据
     */
    @Getter
    @Setter
    private T data;

    /**
     * 成功，不需要返回任何信息
     */
    public static <T> R<T> ok() {
        return result(null, 0, null);
    }

    /**
     * 成功，返回数据
     */
    public static <T> R<T> ok(T data) {
        return result(data, 0, null);
    }

    /**
     * 成功，返回数据、提示信息
     */
    public static <T> R<T> ok(T data, String msg) {
        return result(data, 0, msg);
    }

    /**
     * 失败，不需要返回任何信息
     */
    public static <T> R<T> failed() {
        return result(null, 1, null);
    }

    /**
     * 失败，返回提示信息
     */
    public static <T> R<T> failed(String msg, int code) {
        return result(null, code, msg);
    }

    /**
     * 失败，返回提示信息
     */
    public static <T> R<T> failed(String msg) {
        return result(null, 1, msg);
    }

    /**
     * 失败，返回数据
     */
    public static <T> R<T> failed(T data) {
        return result(data, 1, null);
    }

    /**
     * 失败，返回数据、提示信息
     */
    public static <T> R<T> failed(T data, String msg) {
        return result(data, 1, msg);
    }

    /**
     * 失败，返回数据、错误码、提示信息
     */
    private static <T> R<T> result(T data, int code, String msg) {

        R<T> r = new R<>();

        return r.setCode(code)
                .setData(data)
                .setMsg(msg);
    }

}
