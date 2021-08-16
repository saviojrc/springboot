package com.digitalinonovationone.SpringBootConfig.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import lombok.Getter;
import lombok.Setter;

@Configuration
@ConfigurationProperties("spring.datasource")
@Getter
@Setter
public class DBConfiguration {

	@Autowired
	private AppController app;
	@Value("${app.menssage}")
	private String appMessage;
	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@Profile("dev")
	@Bean
	public String testDataBaseConnection() {
		System.out.println(app.getAppMessage());
		System.out.println(appMessage);
		System.out.println("DB connection for Dev - H2");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to H2_TEST - TEST INSTANCE";
	}
	
	
	@Profile("prod")
	@Bean
	public String productionDataBaseConnection() {
		System.out.println("DB connection for Production - MySQL");
		System.out.println(driverClassName);
		System.out.println(url);
		return "DB Connection to MySQL_TEST - TEST INSTANCE";
		
	}
	
	

	
}
