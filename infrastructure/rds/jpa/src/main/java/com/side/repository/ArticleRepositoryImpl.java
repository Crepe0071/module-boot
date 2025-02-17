package com.side.repository;

import com.side.entity.ArticleEntity;
import com.side.internal.repository.ArticleRepository;
import com.side.mapper.ArticleMapper;
import com.side.model.Article;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ArticleRepositoryImpl implements ArticleRepository {

	private final ArticleJpaRepository repository;

	@Override
	public Article create(String originName) {
		ArticleEntity articleEntity = ArticleEntity.builder()
										  .originalName(originName)
										  .build();

		return ArticleMapper.toDomain(repository.save(articleEntity));
	}

	@Override
	public Article find(String originName) {
		ArticleEntity articleEntity = repository.findByOriginalName(originName)
										  .orElseThrow(() -> new IllegalStateException(originName + "doesn't exist"));

		return ArticleMapper.toDomain(articleEntity);
	}
}
