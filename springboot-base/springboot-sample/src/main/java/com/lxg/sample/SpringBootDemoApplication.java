package com.lxg.sample;

import com.lxg.sample.service.UserService;
import com.lxg.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author lxg
 */
@SpringBootApplication
public class SpringBootDemoApplication {

	@Bean
	public UserService getUserService(){
		return new UserServiceImpl();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
