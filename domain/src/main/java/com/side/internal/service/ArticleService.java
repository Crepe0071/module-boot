package com.side.internal.service;

import com.side.internal.repository.ArticleRepository;
import com.side.model.Article;

public class ArticleService {
	private final ArticleRepository repository;

	public ArticleService(ArticleRepository repository) {
		this.repository = repository;
	}

	public Article create(String originName) {
		return repository.create(originName);
	}

	public Article find(String originName) {
		return repository.find(originName);
	}
}
