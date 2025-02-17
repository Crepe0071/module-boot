package com.side.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Article {
	private String originName;

	public Article(String originName) {
		this.originName = originName;
	}
}
