package com.icu.backstage.controller;

import cn.hutool.core.lang.tree.Tree;
import com.icu.backstage.mybatisplus.entity.Menu;
import com.icu.backstage.service.IMenuService;
import com.icu.backstage.satoken.admin.SaAdminCheckPermission;
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
    @SaAdminCheckPermission("menu/add")
    @PostMapping("add")
    public boolean add(@RequestBody Menu menu)
    {
        return iMenuService.add(menu);
    }

    /**
     * 菜单编辑
     */
    @PutMapping("edit")
    public boolean edit(@RequestBody Menu menu)
    {
        return iMenuService.edit(menu);
    }

    /**
     * 菜单删除
     */
    @DeleteMapping("/del/{id}")
    public boolean del(@PathVariable Long id)
    {
        return iMenuService.del(id);
    }

    /**
     * 菜单列表
     */
    @PostMapping("lists")
    public List<Tree<String>> lists(@RequestBody Menu menu)
    {
        return iMenuService.lists();
    }

}
