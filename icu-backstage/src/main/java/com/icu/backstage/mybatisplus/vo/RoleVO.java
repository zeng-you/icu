package com.icu.backstage.mybatisplus.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 标识（安全框架需要）
     */
    private String code;

    /**
     * 备注
     */
    private String remark;

    /**
     * 类型（0：全部，1：自定义，2：本级及子级，3：本级）
     */
    private String type;

}
