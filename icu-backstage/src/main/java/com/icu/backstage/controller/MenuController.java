package com.icu.backstage.controller;

import cn.hutool.core.lang.tree.Tree;
import com.icu.backstage.mybatisplus.entity.Menu;
import com.icu.backstage.mybatisplus.param.common.IdParam;
import com.icu.backstage.mybatisplus.service.IMenuService;
import com.icu.backstage.satoken.admin.SaAdminCheckPermission;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
     * 菜单添加
     */
    @SaAdminCheckPermission(value = "menu_add", orRole = "admin")
    @PostMapping("add")
    public boolean add(@RequestBody Menu menu)
    {
        return iMenuService.add(menu);
    }

    /**
     * 菜单编辑
     */
    @SaAdminCheckPermission(value = "menu_edit", orRole = "admin")
    @PostMapping("edit")
    public boolean edit(@RequestBody Menu menu)
    {
        return iMenuService.edit(menu);
    }

    /**
     * 菜单删除
     */
    @SaAdminCheckPermission(value = "menu_del", orRole = "admin")
    @PostMapping("del")
    public boolean del(@Validated @RequestBody @NotNull IdParam param)
    {
        return iMenuService.del(param.getId());
    }

    /**
     * 菜单树
     */
    @PostMapping("tree")
    public List<Tree<String>> tree()
    {
        return iMenuService.tree();
    }

}
