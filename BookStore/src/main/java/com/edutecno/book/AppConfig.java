package com.edutecno.book;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.edutecno.book")
@PropertySource("classpath:database.properties")
public class AppConfig {

	@Autowired
	Environment environment;
	
	@Bean
	DataSource dataSource() {
		DriverManagerDataSource dmd = new DriverManagerDataSource();
		dmd.setUrl(environment.getProperty("url"));
		dmd.setUsername(environment.getProperty("dbuser"));
		dmd.setPassword(environment.getProperty("dbpassword"));
		dmd.setDriverClassName(environment.getProperty("driver"));
		
		return dmd;
	}
}