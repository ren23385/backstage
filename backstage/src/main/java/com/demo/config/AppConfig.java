package com.demo.config;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.alibaba.druid.pool.DruidDataSource;
import com.demo.controller.AuthorInterceptor;

@Configuration
public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
		
		DruidDataSource dds = new DruidDataSource();
		dds.setUrl(env.getProperty("spring.datasource.url").trim());
		dds.setUsername(env.getProperty("spring.datasource.username").trim());
		dds.setPassword(env.getProperty("spring.datasource.password").trim());
		dds.setDriverClassName(env.getProperty("spring.datasource.driver-class-name").trim());
		return dds;	
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new AuthorInterceptor()).addPathPatterns("**").excludePathPatterns(Arrays.asList("/static/**"));
		
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		registry.addResourceHandler("/upload/**").addResourceLocations("/WEB-INF/upload/");
	}
	
	
	

}
