package com.icu.backstage.mybatisplus.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.icu.backstage.mybatisplus.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.backstage.mybatisplus.vo.RoleVO;

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
public interface IRoleService extends IService<Role> {

    /**
     * 角色列表
     */
    Map<String, Object> lists();

}
