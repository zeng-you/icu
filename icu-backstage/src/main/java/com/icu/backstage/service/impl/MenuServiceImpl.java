package com.icu.backstage.service.impl;

import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.icu.backstage.mybatisplus.entity.Menu;
import com.icu.backstage.mapper.MenuMapper;
import com.icu.backstage.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.icu.common.tool.util.E;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

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

    /**
     * 菜单添加
     */
    @Override
    public boolean add(Menu menu) {

        boolean save = save(menu);

        if (!save) throw new E("菜单添加失败");

        return true;
    }

    /**
     * 菜单编辑
     */
    @Override
    public boolean edit(Menu menu) {

        boolean update = updateById(menu);

        if (!update) throw new E("菜单编辑失败");

        return true;
    }

    /**
     * 菜单删除
     */
    @Override
    public boolean del(Long id) {

        boolean remove = removeById(id);

        if (!remove) throw new E("菜单删除失败");

        return true;
    }

    /**
     * 菜单树
     */
    @Override
    public List<Tree<String>> tree() {

        List<Menu> lists = list();

        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();

        treeNodeConfig.setParentIdKey("pid");
        treeNodeConfig.setWeightKey("sort");

        treeNodeConfig.setDeep(3);

        return TreeUtil.build(lists, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(String.valueOf(treeNode.getId()));
                    tree.setName(treeNode.getName());
                    tree.putExtra("permission", treeNode.getPermission());
                    tree.putExtra("path", treeNode.getPath());
                    tree.setParentId(String.valueOf(treeNode.getPid()));
                    tree.putExtra("icon", treeNode.getIcon());
                    tree.setWeight(String.valueOf(treeNode.getSort()));
                    tree.putExtra("type", treeNode.getType());
                });
    }


}
