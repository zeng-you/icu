package com.icu.backstage.controller;

import com.icu.backstage.mybatisplus.param.admin.AdminLoginParam;
import com.icu.backstage.mybatisplus.vo.admin.AdminVO;
import com.icu.backstage.mybatisplus.service.admin.IAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Slf4j
@RestController
@RequestMapping("admin")
public class AdminController {

    @Resource
    protected IAdminService iAdminService;

    /**
     * 管理员登录
     */
    @PostMapping("login")
    public Object login(@Validated @RequestBody AdminLoginParam param) {
        return iAdminService.login(param);
    }

    /**
     * 登录详情
     */
    @PostMapping("login/info")
    public AdminVO loginInfo() {
        return iAdminService.loginInfo();
    }

}
