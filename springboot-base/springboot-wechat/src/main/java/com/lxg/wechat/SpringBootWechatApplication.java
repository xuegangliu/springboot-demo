package com.lxg.wechat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 *  @author lxg
 */
@SpringBootApplication
@ServletComponentScan(basePackages="com.lxg.wechat")
public class SpringBootWechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWechatApplication.class, args);
	}
}
