package com.side.mapper;

import com.side.entity.ArticleEntity;
import com.side.model.Article;

public class ArticleMapper {

	public static ArticleEntity toEntity(
		Article article
	) {
		return ArticleEntity.builder()
				   .originalName(article.getOriginName())
				   .build();
	}

	public static Article toDomain(
		ArticleEntity articleEntity
	) {
		return new Article(articleEntity.getOriginalName());
	}
}
