package com.icu.backstage.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Getter
@Setter
@Accessors(chain = true)
public class Admin implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 盐
     */
    private String salt;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 姓名
     */
    private String name;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 部门 department id
     */
    private Long departmentId;

    /**
     * 添加时间
     */
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime addTime;

    /**
     * 编辑时间
     */
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

    /**
     * 状态（0：禁用，1：正常）
     */
    private String status;


}
