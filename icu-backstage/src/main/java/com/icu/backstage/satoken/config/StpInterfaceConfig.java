package com.icu.backstage.satoken.config;

import cn.dev33.satoken.stp.StpInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义权限验证接口扩展
 *
 * @author 曾有
 * @since 2022/5/21
 */
@Slf4j
@Component
public class StpInterfaceConfig implements StpInterface {

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        log.info("----返回一个账号所拥有的权限码集合---loginId：{}，loginType：{}", loginId, loginType);

        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询权限
        List<String> list = new ArrayList<>();

        list.add("menu_edit");

       // if ("1".equals(loginId)) {
           // list.add("**");
     //   }

        return list;
    }

    /**
     * 返回一个账号所拥有的角色标识集合
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        // 本list仅做模拟，实际项目中要根据具体业务逻辑来查询角色
        List<String> list = new ArrayList<>();

        list.add("admin");

        return list;
    }

}