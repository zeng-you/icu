package com.icu.backstage.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.icu.backstage.mapper")
public class MybatisPlusConfig {

}
