package com.icu.backstage.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.mapper.RoleMapper;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import com.icu.common.tool.util.MybatisplusUtil;
import lombok.extern.slf4j.Slf4j;
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
    public Map<String, Object> lists() {

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();

        Page<Role> page = new Page<>(1, 5);
        IPage<Role> userIPage = roleMapper.selectPage(page, wrapper);

        List<RoleVO> roleVOS = userIPage.getRecords().stream().map((source) -> {

            RoleVO roleVO = new RoleVO();

            BeanUtil.copyProperties(source, roleVO);

            return roleVO;
        }).toList();

        return MybatisplusUtil.list(roleVOS, userIPage.getTotal());
    }

}
