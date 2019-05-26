package com.userapp.root;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.userapp.model.User;
import com.userapp.repo.UserRepository;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public DataSource createDataSource() {
		
		/**
		 * spring.datasource.url=jdbc:h2:mem:testdb
		 * spring.datasource.driverClassName=org.h2.Driver spring.datasource.username=sa
		 * spring.datasource.password=password
		 * spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
		 * spring.h2.console.enabled=true
		 */
		
		
		DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
		dataSourceBuilder.driverClassName("org.h2.Driver");
		dataSourceBuilder.url("jdbc:h2:file:~/data");
		dataSourceBuilder.username("sa");
		dataSourceBuilder.password("password");
		return dataSourceBuilder.build();
	}	
}
