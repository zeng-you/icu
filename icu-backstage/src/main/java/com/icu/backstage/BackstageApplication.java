package com.icu.backstage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.icu.backstage.mapper")
public class BackstageApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackstageApplication.class, args);
	}



}
