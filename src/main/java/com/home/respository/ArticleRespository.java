package com.home.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.home.domin.Article;

public interface ArticleRespository extends JpaRepository<Article, Long>{
	
	List<Article> findByTitleLikeOrderByCreateTimeDesc(String Title);
}
