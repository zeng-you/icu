package com.icu.backstage.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.icu.backstage.mybatisplus.mapper")
public class MybatisPlusConfig {

}
