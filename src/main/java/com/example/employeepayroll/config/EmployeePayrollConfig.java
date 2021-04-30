package com.example.employeepayroll.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages="com.example.employeepayroll")
public class EmployeePayrollConfig extends WebSecurityConfigurerAdapter{
 
	@Bean
	public ViewResolver viewResolver() {
		
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		
		viewResolver.setPrefix("src/main/resources/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}

	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.anyRequest()			
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/loginPage")
			.loginProcessingUrl("/authenticateTheUser")
			.permitAll()
			.and()
			.logout()
			.permitAll();
		
	}
	
	
	
}		
