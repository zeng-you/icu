package com.icu.backstage.mybatisplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.icu.backstage.util.SaUtil;
import com.icu.common.tool.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 填充器
 *
 * @author 曾有
 * @since 2022/5/27
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入元对象字段填充（用于插入时对公共字段的填充）
     */
    @Override
    public void insertFill(MetaObject metaObject) {

        LocalDateTime localDateTime = TimeUtil.localDateTime();

        this.strictInsertFill(metaObject, "addTime" , LocalDateTime.class, localDateTime);
        this.strictInsertFill(metaObject, "editTime", LocalDateTime.class, localDateTime);
        this.strictInsertFill(metaObject, "addAdmin", SaUtil::adminId    , Long.class);
    }

    /**
     * 更新元对象字段填充（用于更新时对公共字段的填充）
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        this.strictUpdateFill(metaObject, "editTime", LocalDateTime.class, TimeUtil.localDateTime());
    }


}