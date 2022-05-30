package com.icu.backstage.service;

import com.icu.backstage.mybatisplus.entity.Admin;
import com.icu.backstage.mybatisplus.vo.admin.AdminVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.backstage.mybatisplus.param.admin.AdminLoginParam;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
public interface IAdminService extends IService<Admin> {

    /**
     * 管理员登录
     */
    AdminVO login(AdminLoginParam param);

    /**
     * 登录详情
     */
    AdminVO loginInfo();

}
