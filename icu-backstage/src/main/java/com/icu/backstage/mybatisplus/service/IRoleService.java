package com.icu.backstage.mybatisplus.service;

import com.icu.backstage.mybatisplus.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.backstage.mybatisplus.param.common.IdParam;
import com.icu.backstage.mybatisplus.param.role.RoleListParam;
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
    Map<String, Object> lists(RoleListParam param);

    /**
     * 角色所有
     */
    List<RoleVO> all();

    /**
     * 角色编辑
     */
    boolean edit(Role param);

    /**
     * 角色添加
     */
    boolean add(Role param);

    /**
     * 角色删除
     */
    boolean del(long id);
}
