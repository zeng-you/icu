package com.icu.backstage.service.impl;

import cn.dev33.satoken.secure.SaSecureUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
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

    @Override
    public R<Object> login(LoginParam param) {

        Admin adminOne = getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getPhone, param.getPhone()));

        if (adminOne == null || !SaSecureUtil.sha256(param.getPwd()).equals(adminOne.getPwd())) {
            return R.failed("账号或者密码错误");
        }

        if (!adminOne.getStatus().equals("1")) {
            return R.failed("账号已经被禁用");
        }

        AdminVO adminVO = new AdminVO();

        adminVO = adminVO.setId(adminOne.getId())
                .setPhone(adminOne.getPhone())
                .setAvatar(adminOne.getAvatar())
                .setName(adminOne.getName())
                .setEmail(adminOne.getEmail())
                .setStatus(adminOne.getStatus());
        
        return R.ok(adminVO);
    }

}
