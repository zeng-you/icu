package com.icu.backstage.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.icu.backstage.entity.Admin;
import com.icu.backstage.entity.vo.AdminVO;
import com.icu.backstage.mapper.AdminMapper;
import com.icu.backstage.entity.param.admin.LoginParam;
import com.icu.backstage.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.common.tool.util.R;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    /**
     * 管理员登录
     */
    @Override
    public R<AdminVO> login(LoginParam param) {

        Admin adminOne = getOne(new QueryWrapper<Admin>().eq("phone", param.getPhone()));

        if (adminOne == null || !SaSecureUtil.sha256(param.getPwd()).equals(adminOne.getPwd())) {
            return R.failed("账号或者密码错误");
        }

        if (!adminOne.getStatus().equals("1")) {
            return R.failed("账号已经被禁用");
        }

        AdminVO adminVO = new AdminVO();

        BeanUtil.copyProperties(adminOne, adminVO);

        StpUtil.login(adminOne.getId());

        adminVO = adminVO.setToken(StpUtil.getTokenValue());

        return R.ok(adminVO);
    }

}
