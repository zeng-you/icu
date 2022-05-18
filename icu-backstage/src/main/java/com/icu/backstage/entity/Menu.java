package com.icu.backstage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
@Getter
@Setter
@Accessors(chain = true)
public class Menu implements Serializable {

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

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime addTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime editTime;

    private Long addAdmin;

    private Long editAdmin;

    /**
     * 删除（0：否，1：是）
     */
    @TableLogic
    private String del;


}
