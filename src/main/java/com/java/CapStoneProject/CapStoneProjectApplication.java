package com.java.CapStoneProject;

import com.java.CapStoneProject.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CapStoneProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(CapStoneProjectApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean<JwtFilter> jwtFilter(){
		FilterRegistrationBean<JwtFilter> RegistrationBean = new FilterRegistrationBean();
		RegistrationBean.setFilter(new JwtFilter());
		RegistrationBean.addUrlPatterns("/api/v1/*");
		return RegistrationBean;
	}

}