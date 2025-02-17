package com.side.internal.repository;

import com.side.model.Article;

public interface ArticleRepository {

	Article create(String originName);

	Article find(String originName);
}
