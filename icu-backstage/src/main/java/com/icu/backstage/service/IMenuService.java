package com.icu.backstage.service;

import com.icu.backstage.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.icu.common.tool.util.R;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
public interface IMenuService extends IService<Menu> {

    /**
     * 添加菜单
     */
    R<Boolean> add(Menu menu);
}
