package com.icu.backstage.mybatisplus.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;

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
public class AdminIdCardVO {

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

}
