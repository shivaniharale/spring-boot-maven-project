package com.example.employeepayroll.configuration;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.example.employeepayroll.rest")
@PropertySource("classpath:application.properties")
public class WebSecurityConfig {

        @Autowired
        private Environment environment;

        @Bean
        public ViewResolver viewResolver() {

            InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("/WEB-INF/view/");
            viewResolver.setSuffix(".jsp");

            return viewResolver;
        }


		@Bean
		public DataSource dataSource() {

			ComboPooledDataSource dataSource= new ComboPooledDataSource();

			try {
				dataSource.setDriverClass(environment.getProperty("jdbc:mysql://localhost:3306/employee_payroll"));
			} catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}

			dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/employee_payroll");
			dataSource.setUser("root");
			dataSource.setPassword("root");

			dataSource.setInitialPoolSize(5);

			dataSource.setMinPoolSize(5);

			dataSource.setMaxPoolSize(20);

			dataSource.setMaxIdleTime(3000);

            return dataSource;
		}




    }