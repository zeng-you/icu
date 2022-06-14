package com.icu.backstage.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理身份证
 * </p>
 *
 * @author 曾有
 * @since 2022-06-14
 */
@Getter
@Setter
@Accessors(chain = true)
public class AdminIdCard implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private String gender;

    /**
     * 民族
     */
    private String nationality;

    /**
     * 身份证号码
     */
    private String number;

    /**
     * 地址
     */
    private String address;

    /**
     * 发证机关
     */
    private String issuingAuthority;

    /**
     * 有效起始时间
     */
    private LocalDate effectiveStartTime;

    /**
     * 有效截止时间
     */
    private LocalDate effectiveDeadline;

    /**
     * admin id
     */
    @TableId
    private Long adminId;

    /**
     * 身份证扫描件正面
     */
    private String front;

    /**
     * 身份证扫描件反面
     */
    private String back;

    /**
     * 出生日期
     */
    private LocalDate birthday;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 身份证头像
     */
    private String avatar;

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
     * 删除（0：否，1：是）
     */
    @TableLogic
    private String del;

    /**
     * 所属租户 tenant id
     */
    private Long tenantId;


}
