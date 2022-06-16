package com.icu.backstage.mybatisplus.vo.admin;

import java.io.Serial;
import java.io.Serializable;

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
public class AdminVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态（0：禁用，1：正常）
     */
    private String status;

    /**
     * 令牌
     */
    private String token;

    /**
     * 所属租户 tenant id
     */
    private long tenantId;

    /**
     * 身份证
     */
    private AdminIdCardVO idCard;

}
