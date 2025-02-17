package com.side.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.side.internal.repository.ArticleRepository;
import com.side.internal.service.ArticleService;
import com.side.repository.ArticleJpaRepository;
import com.side.repository.ArticleRepositoryImpl;

@Configuration
public class ArticleUseCaseConfig {

	@Bean
	public ArticleRepository articleRepository(ArticleJpaRepository articleJpaRepository) {
		return new ArticleRepositoryImpl(articleJpaRepository);
	}

	@Bean
	public ArticleService articleService(ArticleRepository articleRepository) {
		return new ArticleService(articleRepository);
	}
}
