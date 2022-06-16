package com.icu.backstage.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import org.springframework.web.bind.annotation.PostMapping;
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
    public Map<String, Object> lists() {
        return iRoleService.lists();
    }

}
