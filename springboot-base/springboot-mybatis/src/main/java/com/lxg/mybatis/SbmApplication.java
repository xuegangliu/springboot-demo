package com.lxg.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lxg
 */
@SpringBootApplication
@ComponentScan(value = "com.lxg.mybatis.*")
public class SbmApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbmApplication.class, args);
	}
}
