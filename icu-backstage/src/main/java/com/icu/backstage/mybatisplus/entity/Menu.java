package com.icu.backstage.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
public class Menu implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

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
    private Long pid;

    /**
     * 图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 类型（0：左菜单，1：按钮，2：顶菜单）
     */
    private String type;

    /**
     * 添加时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime addTime;

    /**
     * 编辑时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

    /**
     * 添加管理员 admin id
     */
    private Long addAdmin;

    /**
     * 编辑管理员 admin id
     */
    private Long editAdmin;

    /**
     * 删除（0：否，1：是）
     */
    private String del;


}
