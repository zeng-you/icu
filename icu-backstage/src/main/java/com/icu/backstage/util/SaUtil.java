package com.icu.backstage.util;

import com.icu.backstage.satoken.admin.StpAdminUtil;

/**
 * sa-token
 * @author 曾有
 * @since 2022/5/27
 */
public class SaUtil {

    /**
     * 获取管理员登录Id
     */
    public static Long adminId() {
        return Long.parseLong(String.valueOf(StpAdminUtil.getLoginId()));
    }

}
