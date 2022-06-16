package com.icu.common.tool.util;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/**
 * mybatisplus
 * @author 曾有
 * @since 2022/6/16
 */
public class MybatisplusUtil {

    public static @NotNull Map<String, Object> list(Object param, Long total) {

        Map<String, Object> data = new HashMap<>();

        data.put("list", param);
        data.put("total", total);

        return data;
    }

}
