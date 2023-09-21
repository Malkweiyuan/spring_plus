package com.example.springplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
@SpringBootApplication
@MapperScan("com.example.springplus.mapper")
@EnableAsync
@EnableScheduling
public class SpringPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringPlusApplication.class, args);
	}

}
