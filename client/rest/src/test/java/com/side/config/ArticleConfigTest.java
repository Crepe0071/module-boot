package com.side.config;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import com.side.internal.repository.ArticleRepository;
import com.side.internal.service.ArticleService;
import com.side.repository.ArticleJpaRepository;
import com.side.repository.ArticleRepositoryImpl;

@TestConfiguration
public class ArticleConfigTest {
	@Bean
	public ArticleRepository articleRepository(ArticleJpaRepository articleJpaRepository) {
		return new ArticleRepositoryImpl(articleJpaRepository);
	}

	@Bean
	public ArticleService articleService(ArticleRepository articleRepository) {
		return new ArticleService(articleRepository);
	}
}
