package com.icu.backstage.mybatisplus.param.role;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 角色列表
 * </p>
 *
 * @author 曾有
 * @since 2022-05-18
 */
@Getter
@Setter
@Accessors(chain = true)
public class RoleListParam {

    /**
     * 名称
     */
    private String name;

    /**
     * 当前页
     */
    @Min(value = 1, message = "当前页不能为空")
    private long current;

    /**
     * 每页显示条数
     */
    @Min(value = 1, message = "每页显示条数不能为空")
    private long size;

}
