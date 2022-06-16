package com.icu.backstage.mybatisplus.param.role;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

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
    private Long current;

    /**
     * 每页显示条数
     */
    private Long size;


}
