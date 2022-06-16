package com.icu.backstage.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.mapper.RoleMapper;
import com.icu.backstage.mybatisplus.param.common.IdParam;
import com.icu.backstage.mybatisplus.param.role.RoleListParam;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import com.icu.common.tool.util.E;
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
    public Map<String, Object> lists(@NotNull RoleListParam param) {

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
     * 角色编辑
     */
    @Override
    public boolean edit(Role param) {

        boolean update = updateById(param);

        if (!update) throw new E("角色编辑失败");

        return true;
    }

    /**
     * 角色添加
     */
    @Override
    public boolean add(Role param) {

        boolean save = save(param);

        if (!save) throw new E("角色添加失败");

        return true;
    }

    /**
     * 角色删除
     */
    @Override
    public boolean del(long id) {

        boolean del = removeById(id);

        if (!del) throw new E("角色删除失败");

        return true;
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
