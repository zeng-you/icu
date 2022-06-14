package com.icu.backstage.mybatisplus.param.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * <p>
 * id
 * </p>
 *
 * @author 曾有
 * @since 2022-05-14
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class IdParam {

    private Long id;

}
