package com.home.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.home.domin.Article;
import com.home.respository.ArticleRespository;



@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleRespository articleRespository;
	
	@Transactional
	@Override
	public Article save(Article article) {	
		return articleRespository.save(article);
	}
	
	@Transactional
	@Override
	public void addReading(Long id) {
		Article article=articleRespository.getOne(id);
		article.setReading(article.getReading()+1);
		articleRespository.save(article);
	}

	@Transactional
	@Override
	public void addLikes(Long id) {
		Article article=articleRespository.getOne(id);
		article.setLikes(article.getLikes()+1);
		articleRespository.save(article);
	}

	@Transactional
	@Override
	public Article getArticleById(Long id) {
		return articleRespository.getOne(id);
	}

	@Override
	public List<Article> sortArticleByCreateTime(String title) {
		
		title = "%" + title + "%";
		return articleRespository.findByTitleLikeOrderByCreateTimeDesc(title);
	}
	

}
