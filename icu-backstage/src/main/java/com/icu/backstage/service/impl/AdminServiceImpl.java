package com.icu.backstage.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icu.backstage.mybatisplus.entity.Admin;
import com.icu.backstage.mybatisplus.vo.admin.AdminVO;
import com.icu.backstage.mapper.AdminMapper;
import com.icu.backstage.mybatisplus.param.admin.AdminLoginParam;
import com.icu.backstage.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.satoken.admin.StpAdminUtil;
import com.icu.backstage.util.SaUtil;
import com.icu.common.tool.util.E;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Slf4j
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    /**
     * 管理员登录
     */
    @Override
    public AdminVO login(AdminLoginParam param) {

        QueryWrapper<Admin> wrapper = new QueryWrapper<Admin>().eq("phone", param.getPhone());

        if (param.getTenantId() != null) {
            wrapper.eq("tenant_id", param.getTenantId());
        }

        Admin adminOne = getOne(wrapper);

        if (adminOne == null || !SaSecureUtil.sha256(param.getPwd()).equals(adminOne.getPwd())) {
            throw new E("账号或者密码错误");
        }

        if (!adminOne.getStatus().equals("1")) {
            throw new E("账号已经被禁用");
        }

        AdminVO adminVO = new AdminVO();

        BeanUtil.copyProperties(adminOne, adminVO);

        StpAdminUtil.login(adminOne.getId());

        adminVO = adminVO.setToken(StpUtil.getTokenValue());

        return adminVO;
    }

    /**
     * 登录详情
     */
    @Override
    public AdminVO loginInfo() {

        Admin adminOne = getOne(new QueryWrapper<Admin>().eq("id", SaUtil.adminId()));

        AdminVO adminVO = new AdminVO();

        BeanUtil.copyProperties(adminOne, adminVO);

        return adminVO;
    }

}
