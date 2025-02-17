package com.side.usecase;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.side.internal.service.ArticleService;
import com.side.model.Article;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleUseCase {
	private final ArticleService articleService;

	@Transactional
	public String create(String originName) {
		Article article = articleService.create(originName);
		return article.getOriginName();
	}

	@Transactional(readOnly = true)
	public String find(String originName) {
		Article article = articleService.find(originName);
		return article.getOriginName();
	}

}
