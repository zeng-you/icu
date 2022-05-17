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

    // 测试登录，浏览器访问： http://localhost:8081/user/doLogin?username=zhang&password=123456
    @RequestMapping("doLogin")
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:8081/user/isLogin
    @RequestMapping("isLogin")
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}
