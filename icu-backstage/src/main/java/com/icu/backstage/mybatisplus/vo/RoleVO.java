package com.icu.backstage.mybatisplus.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serial;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author 曾有
 * @since 2022-06-15
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class RoleVO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 备注
     */
    private String remark;

}
