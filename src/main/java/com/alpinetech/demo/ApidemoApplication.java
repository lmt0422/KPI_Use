package com.alpinetech.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(scanBasePackages = {"com.alpinetech.*"})
@MapperScan(basePackages={"com.alpinetech.demo.mapper"})
public class ApidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApidemoApplication.class, args);
	}

}
