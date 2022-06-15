package com.icu.backstage.mybatisplus.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.icu.backstage.mybatisplus.entity.Admin;
import com.icu.backstage.mybatisplus.entity.AdminIdCard;
import com.icu.backstage.mybatisplus.mapper.AdminIdCardMapper;
import com.icu.backstage.mybatisplus.service.IAdminService;
import com.icu.backstage.mybatisplus.vo.AdminIdCardVO;
import com.icu.backstage.mybatisplus.vo.admin.AdminVO;
import com.icu.backstage.mybatisplus.mapper.AdminMapper;
import com.icu.backstage.mybatisplus.param.admin.AdminLoginParam;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.satoken.admin.StpAdminUtil;
import com.icu.backstage.util.SaUtil;
import com.icu.common.tool.enums.CodeEnum;
import com.icu.common.tool.util.E;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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

    @Resource
    private AdminIdCardMapper adminIdCardMapper;

    /**
     * 管理员登录
     */
    @Override
    public AdminVO login(@NotNull AdminLoginParam param) {

        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<Admin>().eq(Admin::getPhone, param.getPhone());

        if (param.getTenantId() != null) {
            wrapper.eq(Admin::getTenantId, param.getTenantId());
        }

        Admin adminOne = getOne(wrapper);

        if (adminOne == null || !SaSecureUtil.sha256(param.getPwd()).equals(adminOne.getPwd())) {
            throw new E("账号或者密码错误");
        }

        if (!adminOne.getStatus().equals("1")) {
            throw new E("账号已经被禁用");
        }

        StpAdminUtil.login(adminOne.getId());

        return infoBase(adminOne).setToken(StpUtil.getTokenValue());
    }

    /**
     * 登录详情
     */
    @Override
    public AdminVO loginInfo() {

        Admin adminOne = getOne(new LambdaQueryWrapper<Admin>().eq(Admin::getId, SaUtil.adminId()));

        if (adminOne == null) throw new E(CodeEnum.LOGIN_EXPIRED.getMsg(), CodeEnum.LOGIN_EXPIRED.getCode());

        return infoBase(adminOne);
    }

    /**
     * 管理员详情公共处理逻辑
     */
    private AdminVO infoBase(@NotNull Admin admin) {

        AdminIdCard idCard = adminIdCardMapper.selectOne(new LambdaQueryWrapper<AdminIdCard>().eq(AdminIdCard::getAdminId, admin.getId()));

        AdminVO adminVO = new AdminVO();

        BeanUtil.copyProperties(admin, adminVO);

        AdminIdCardVO idCardVO = new AdminIdCardVO();

        BeanUtil.copyProperties(idCard, idCardVO);

        adminVO.setIdCard(idCardVO);

        return adminVO;
    }

}
