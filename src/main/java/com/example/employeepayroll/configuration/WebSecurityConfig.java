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
				dataSource.setDriverClass(environment.getProperty("spring.datasource.url"));
			} catch (PropertyVetoException exc) {
				throw new RuntimeException(exc);
			}

			Logger logger= Logger.getLogger(getClass().getName());

			logger.info("jdbc.url=" + environment.getProperty("spring.datasource.url"));
			logger.info(" jdbc.user=" + environment.getProperty("spring.datasource.username"));


			dataSource.setJdbcUrl(environment.getProperty("spring.datasource.url"));
			dataSource.setUser(environment.getProperty("spring.datasource.username"));
			dataSource.setPassword(environment.getProperty("spring.datasource.password"));


			dataSource.setInitialPoolSize(Integer.parseInt(environment.getProperty("connection.pool.initialPoolSize")));

			dataSource.setMinPoolSize(Integer.parseInt(environment.getProperty("connection.pool.minPoolSize")));

			dataSource.setMaxPoolSize(Integer.parseInt(environment.getProperty("connection.pool.maxPoolSize")));

			dataSource.setMaxIdleTime(Integer.parseInt(environment.getProperty("connection.pool.maxIdleTime")));

			return dataSource;
		}




    }