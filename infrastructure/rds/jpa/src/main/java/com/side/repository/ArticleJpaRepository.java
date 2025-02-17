package com.side.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.side.entity.ArticleEntity;

@Repository
public interface ArticleJpaRepository extends JpaRepository<ArticleEntity, Long> {
	Optional<ArticleEntity> findByOriginalName(String originalName);
}
