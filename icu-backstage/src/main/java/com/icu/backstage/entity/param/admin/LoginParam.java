package com.icu.backstage.entity.param.admin;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

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
@Accessors(chain = true)
public class LoginParam {

    /**
     * 密码
     */
    private String pwd;

    /**
     * 手机号码
     */
    private String phone;

}
