package com.icu.backstage.service.impl;

import com.icu.backstage.entity.Admin;
import com.icu.backstage.mapper.AdminMapper;
import com.icu.backstage.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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

}
