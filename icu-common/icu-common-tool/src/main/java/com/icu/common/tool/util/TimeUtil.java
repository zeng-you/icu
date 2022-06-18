package com.icu.common.tool.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.LocalDateTimeUtil;

import java.time.LocalDateTime;

/**
 * 时间
 * @author 曾有
 * @since 2022/6/16
 */
public class TimeUtil {

    /**
     * 当前时间 yyyy-MM-dd HH:mm:ss
     */
    public static LocalDateTime localDateTime() {

        LocalDateTime time = LocalDateTime.now();

        String pattern = DatePattern.NORM_DATETIME_PATTERN;

        String timeStr = LocalDateTimeUtil.format(time, pattern);

        return LocalDateTimeUtil.parse(timeStr, pattern);
    }

}
