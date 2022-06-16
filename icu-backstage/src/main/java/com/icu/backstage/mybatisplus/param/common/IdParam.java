package com.icu.backstage.mybatisplus.param.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.Min;

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

    @Min(value = 1, message = "必要参数出现异常")
    private long id;

}
