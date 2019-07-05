package com.home.service;

import java.util.List;

import com.home.domin.Article;

public interface ArticleService {
	
	Article save(Article article);
	
	void addReading(Long id);
	
	void addLikes(Long id);
	
	Article getArticleById(Long id);
	
	List<Article> sortArticleByCreateTime(String title);
}
