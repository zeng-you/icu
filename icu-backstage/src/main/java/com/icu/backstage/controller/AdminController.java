package com.icu.backstage.controller;

import com.icu.backstage.entity.param.admin.LoginParam;
import com.icu.backstage.entity.vo.AdminVO;
import com.icu.backstage.service.IAdminService;
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
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    protected IAdminService iAdminService;

    /**
     * 管理员登录
     */
    @PostMapping("login")
    public AdminVO login(@RequestBody LoginParam param) {
        return iAdminService.login(param);
    }

}
