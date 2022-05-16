package com.icu.backstage.controller;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.icu.backstage.entity.Admin;
import com.icu.backstage.service.IAdminService;
import com.icu.common.tool.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 管理员 前端控制器
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private IAdminService iAdminService;

    @PostMapping("login")
    public R<Object> login() {

        Admin adminInfo = iAdminService.getOne(null);

        return R.ok(SaSecureUtil.sha256("888888"));
      //  return R.ok(adminInfo);
    }

}
