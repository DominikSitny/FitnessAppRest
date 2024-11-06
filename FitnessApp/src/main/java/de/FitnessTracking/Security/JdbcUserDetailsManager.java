package de.FitnessTracking.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class JdbcUserDetailsManager {

	@Bean
	DataSource dataSource() {
		return new EmbeddedDatabaseBuilder()
			.setType(null)
			.addScript(JdbcDaoImpl.DEFAULT_USER_SCHEMA_DDL_LOCATION)
			.build();
	}
	
}
