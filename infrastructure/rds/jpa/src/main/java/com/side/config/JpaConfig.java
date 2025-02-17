package com.side.config;

import java.util.Arrays;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.side.repository") // 본인 패키지에 맞게 수정
public class JpaConfig {

	private final Environment env;

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(dataSource);
		// 엔티티 스캔 패키지 지정 (본인 프로젝트에 맞게 수정)
		em.setPackagesToScan("com.side.entity");

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);

		Properties jpaProperties = new Properties();
		boolean isProd = env.acceptsProfiles(Profiles.of("prod"));
		jpaProperties.put("hibernate.hbm2ddl.auto", isProd ? "validate" : "create-drop");
		jpaProperties.put("hibernate.show_sql", isProd ? "false" : "true");
		if (!isProd) {
			jpaProperties.put("hibernate.format_sql", "true");
		}
		// open-in-view false는 별도의 OpenEntityManagerInViewFilter를 등록하지 않으면 기본값으로 꺼짐
		em.setJpaProperties(jpaProperties);

		return em;
	}

	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		return new JpaTransactionManager(emf);
	}

	// DataSource는 따로 HikariCP나 다른 방법으로 빈 등록했다고 가정
}
