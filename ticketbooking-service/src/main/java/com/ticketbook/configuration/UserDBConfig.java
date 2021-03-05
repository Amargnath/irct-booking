package com.ticketbook.configuration;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "authenticateEntityManagerFactory", basePackages = {
		"com.ticketbook.user.repository" }, transactionManagerRef = "authtransactionManager")
public class UserDBConfig {

	@Bean(name = "dataSource2")

	@ConfigurationProperties("spring.datasource2")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean authenticateEntityManagerFactory(EntityManagerFactoryBuilder builder,

			@Qualifier("dataSource2") DataSource dataSource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		return builder.dataSource(dataSource).properties(properties).packages("com.ticketbook.user.entity")
				.persistenceUnit("User").build();

	}

	@Bean(name = "authtransactionManager")
	public PlatformTransactionManager authtransactionManager(

			@Qualifier("authenticateEntityManagerFactory") EntityManagerFactory authenticateEntityManagerFactory) {
		return new JpaTransactionManager(authenticateEntityManagerFactory);
	}

}
