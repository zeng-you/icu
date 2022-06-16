package com.icu.backstage.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.mapper.RoleMapper;
import com.icu.backstage.mybatisplus.param.menu.MenuListParam;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import com.icu.common.tool.util.MybatisplusUtil;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

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
@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Resource
    protected RoleMapper roleMapper;

    /**
     * 角色列表
     */
    @Override
    public Map<String, Object> lists(MenuListParam param) {

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>().orderByDesc(Role::getId);

        if (!StrUtil.isBlank(param.getName())) wrapper.like(Role::getName, param.getName());

        Page<Role> page = new Page<>(param.getCurrent(), param.getSize());

        IPage<Role> roleIPage = roleMapper.selectPage(page, wrapper);

        return MybatisplusUtil.list(roleStream(roleIPage.getRecords()), roleIPage.getTotal());
    }

    /**
     * 角色所有
     */
    @Override
    public List<RoleVO> all() {

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<Role>().orderByDesc(Role::getId);

        return roleStream(roleMapper.selectList(wrapper));
    }

    /**
     * 角色返回结果集处理
     */
    public List<RoleVO> roleStream(@NotNull List<Role> roles) {
        return roles.stream().map((role) -> {

            RoleVO roleVO = new RoleVO();

            BeanUtil.copyProperties(role, roleVO);

            return roleVO;
        }).toList();
    }

}
