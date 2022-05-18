package com.icu.backstage.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.icu.backstage.entity.param.admin.LoginParam;
import com.icu.backstage.entity.vo.AdminVO;
import com.icu.backstage.service.IAdminService;
import com.icu.common.tool.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public R<AdminVO> login(@RequestBody LoginParam param) {
        return iAdminService.login(param);
    }

}
