package com.icu.backstage.service;

import com.icu.backstage.entity.Admin;
import com.icu.backstage.entity.vo.AdminVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.backstage.entity.param.admin.LoginParam;
import com.icu.common.tool.util.R;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
public interface IAdminService extends IService<Admin> {

    R<AdminVO> login(LoginParam param);

}
