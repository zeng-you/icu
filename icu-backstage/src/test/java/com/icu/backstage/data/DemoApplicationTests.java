package com.icu.backstage.data;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.fill.Column;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.springframework.boot.test.mock.mockito.MockReset.before;

/**
 * @author 曾有
 * @since 2022-03-22
 */
@SpringBootTest
@Slf4j
class DemoApplicationTests {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig.Builder DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:p6spy:postgresql://127.0.0.1:5432/icu", "postgres", "postgres");

    /**
     * 执行 run
     */
    @Test
    void table() {

        before();

        FastAutoGenerator.create(DATA_SOURCE_CONFIG)
                // 全局配置
                .globalConfig((scanner, builder) -> builder.author(scanner.apply("曾有"))
                        .outputDir("E:\\www\\java")
                )

                // 包配置
                .packageConfig((scanner, builder) -> builder.parent(scanner.apply("com.icu.backstage")))

                // 策略配置
                .strategyConfig((scanner, builder) -> builder.addInclude(getTables(scanner.apply("admin")))
                        .controllerBuilder()
                        .enableRestStyle()
                        .enableHyphenStyle()
                        .entityBuilder()
                        .enableLombok()
                        .addTableFills(
                                new Column("add_time", FieldFill.INSERT),
                                new Column("edit_time", FieldFill.UPDATE)
                        )
                )

                .execute();

    }


    // 处理 all 情况
    protected static List<String> getTables(String tables) {
        return "all".equals(tables) ? Collections.emptyList() : Arrays.asList(tables.split(","));
    }





}
