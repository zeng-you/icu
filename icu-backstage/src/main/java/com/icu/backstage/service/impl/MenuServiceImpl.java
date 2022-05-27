package com.icu.backstage.service.impl;

import cn.hutool.core.date.DateTime;
import com.icu.backstage.mybatisplus.entity.Menu;
import com.icu.backstage.mapper.MenuMapper;
import com.icu.backstage.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.backstage.util.SaUtil;
import com.icu.common.tool.util.E;
import com.icu.common.tool.util.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
@Slf4j
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Resource
    private MenuMapper menuMapper;

    /**
     * 菜单添加
     */
    @Override
    public boolean add(Menu menu) {

        menu = menu.setAddAdmin(SaUtil.adminId());

        int insert = menuMapper.insert(menu);

        if (insert == 0) throw new E("菜单添加失败");

        return true;
    }
}
