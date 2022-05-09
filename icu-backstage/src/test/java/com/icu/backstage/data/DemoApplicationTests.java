package com.icu.backstage.data;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.fill.Column;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 曾有
 * @since 2022-03-22
 */
@SpringBootTest
@Slf4j
class DemoApplicationTests {

    /**
     * 执行 run
     */
    @Test
    void table() {
        FastAutoGenerator.create("jdbc:p6spy:postgresql://127.0.0.1:5432/icu", "postgres", "postgres")

                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("曾有")).fileOverride())

                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("com.icu.backstage")))

                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("admin")))
                        .controllerBuilder().enableRestStyle().enableHyphenStyle()
                        .entityBuilder().enableLombok().addTableFills(
                                new Column("add_time", FieldFill.INSERT),
                                new Column("edit_time", FieldFill.UPDATE)
                        ).build())

                /*
                    模板引擎配置，默认 Velocity 可选模板引擎 Beetl 或 Freemarker
                   .templateEngine(new BeetlTemplateEngine())
                   .templateEngine(new FreemarkerTemplateEngine())
                 */

                .execute();

    }

    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }


}
