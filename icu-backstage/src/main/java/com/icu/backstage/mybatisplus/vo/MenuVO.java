package com.icu.backstage.mybatisplus.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 菜单
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
@Getter
@Setter
@Accessors(chain = true)
public class MenuVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 权限标识
     */
    private String permission;

    /**
     * 组件路径
     */
    private String path;

    /**
     * 父级id（menu id）
     */
    private long pid;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private int sort;

    /**
     * 类型（0：左菜单，1：按钮，2：顶菜单）
     */
    private String type;

}
