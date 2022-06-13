package com.icu.backstage.mybatisplus.param.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 管理员登录
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class AdminLoginParam {

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    private String pwd;

    /**
     * 手机号码
     */
    @NotBlank(message = "手机号码不能为空")
    private String phone;

    /**
     * 所属租户 tenant id
     */
    private Long tenantId;

}
