package com.middle.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan(basePackages = "com.middle.main")
public class MiddleConfig {
	  @Bean  
	  public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		  return new PropertySourcesPlaceholderConfigurer();
	  }
}
