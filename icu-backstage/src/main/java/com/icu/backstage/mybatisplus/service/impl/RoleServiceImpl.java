package com.icu.backstage.mybatisplus.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.icu.backstage.mybatisplus.entity.Role;
import com.icu.backstage.mybatisplus.mapper.RoleMapper;
import com.icu.backstage.mybatisplus.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.mybatisplus.vo.RoleVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.List;

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
    public IPage<Role> lists() {

        LambdaQueryWrapper<Role> wrapper = new LambdaQueryWrapper<>();

        List<Role> roles = list();


        Page<Role> page = new Page<>(1, 5);
        IPage<Role> userIPage = roleMapper.selectPage(page, wrapper);
        Assertions.assertSame(userIPage, page);


       /* List<RoleVO> roleVOS = roles.stream().map((source) -> {

            RoleVO roleVO = new RoleVO();

            BeanUtil.copyProperties(source, roleVO);

            return roleVO;
        }).toList();*/

        log.info("-----------userIPage-----------{}", userIPage);
        log.info("-----------page-----------{}", page);

        print(userIPage.getRecords());

        return userIPage;
    }

    private <T> void print(List<T> list) {
        if (!CollectionUtils.isEmpty(list)) {
            list.forEach(System.out::println);
        }
    }

}
