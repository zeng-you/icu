package com.icu.backstage.service;

import com.icu.backstage.mybatisplus.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.common.tool.util.R;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 菜单添加
     */
    boolean add(Menu menu);

    /**
     * 菜单编辑
     */
    boolean edit(Menu menu);

    /**
     * 菜单删除
     */
    boolean del(Long id);
}
