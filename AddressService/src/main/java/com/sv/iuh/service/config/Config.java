package com.sv.iuh.service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("com.sv.iuh.service")
@PropertySource({"classpath:application.properties"})
public class Config {
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
