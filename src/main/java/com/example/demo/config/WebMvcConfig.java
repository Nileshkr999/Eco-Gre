package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/access-denied").setViewName("access-denied");
		registry.addViewController("/").setViewName("index");
		registry.addViewController("/about-us").setViewName("about-us");
		registry.addViewController("/world").setViewName("world");
		registry.addViewController("/india").setViewName("india");
		registry.addViewController("/states").setViewName("states");

	}

}