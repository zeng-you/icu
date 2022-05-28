package com.icu.backstage.mybatisplus.param.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

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
    @NotEmpty(message = "密码 is NotEmpty")
    @NotBlank(message = "密码 is NotBlank")
    private String pwd;

    /**
     * 手机号码
     */
    @NotEmpty(message = "手机号码 is NotEmpty")
    @NotBlank(message = "手机号码 is NotBlank")
    private String phone;

}
