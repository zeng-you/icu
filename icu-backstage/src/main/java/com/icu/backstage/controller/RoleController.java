package com.icu.backstage.controller;

import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.param.common.IdParam;
import com.icu.backstage.mybatisplus.param.role.RoleListParam;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import com.icu.backstage.satoken.admin.SaAdminCheckPermission;
import org.jetbrains.annotations.NotNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  角色
 * </p>
 *
 * @author 曾有
 * @since 2022-06-15
 */
@RestController
@RequestMapping("role")
public class RoleController {

    @Resource
    protected IRoleService iRoleService;

    /**
     * 角色列表
     */
    @PostMapping("lists")
    public Map<String, Object> lists(@Validated @RequestBody RoleListParam param) {
        return iRoleService.lists(param);
    }

    /**
     * 角色所有
     */
    @PostMapping("all")
    public List<RoleVO> all() {
        return iRoleService.all();
    }

    /**
     * 角色编辑
     */
    @SaAdminCheckPermission(value = "role_edit", orRole = "admin")
    @PostMapping("edit")
    public boolean edit(@RequestBody Role param) {
        return iRoleService.edit(param);
    }

    /**
     * 角色添加
     */
    @SaAdminCheckPermission(value = "role_add", orRole = "admin")
    @PostMapping("add")
    public boolean add(@RequestBody Role param) {
        return iRoleService.add(param);
    }

    /**
     * 角色删除
     */
    @SaAdminCheckPermission(value = "role_del", orRole = "admin")
    @PostMapping("del")
    public boolean del(@Validated @RequestBody @NotNull IdParam param) {
        return iRoleService.del(param.getId());
    }

}
