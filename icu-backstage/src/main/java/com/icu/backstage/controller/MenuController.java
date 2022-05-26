package com.icu.backstage.controller;

import com.icu.backstage.service.IMenuService;
import com.icu.backstage.satoken.admin.SaAdminCheckPermission;
import com.icu.common.tool.util.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Resource
    protected IMenuService iMenuService;

    /**
     * 添加菜单
     */
    @SaAdminCheckPermission("menu/add")
    @PostMapping("add")
    public R<Boolean> add() {
        return R.ok();
    }
    /*public R<Boolean> add(@RequestBody Menu menu)
    {
        return iMenuService.add(menu);
    }*/

}
