package com.home.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.home.domin.Article;
import com.home.service.ArticleService;
import com.home.tools.JsonData;

@RestController
public class MainController {
	
	@Autowired
	private ArticleService articleService;
	
	@GetMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:/index");
	}
	
	@GetMapping("/index")
	public ModelAndView index(Model model) {
		List<Article> articles=articleService.sortArticleByCreateTime("");
		System.out.println(articles.size());
		model.addAttribute("articles", articles);
		model.addAttribute("title", articles.get(0).getTitle());
		return new ModelAndView("/index");
	}
	
	@GetMapping("/game")
	public ModelAndView game() {
		
		return new ModelAndView("/game");
	}
	
	@GetMapping("/photo")
	public ModelAndView photo() {
		
		return new ModelAndView("/MyPhoto");
	}
	
	
	@PostMapping("/addarticle")
	public String addArticle(HttpServletRequest request,String title,String content,String summary,int type) {		
		String callback=request.getParameter("callback");
		JsonData jsonData;
		Article article=new Article(title, content, type,summary);
		articleService.save(article);
		jsonData=new JsonData("200", "success", "创建文章成功", callback);
		return jsonData.toString();
	}
	
	@GetMapping("/article/{id}")
	public ModelAndView article(@PathVariable("id") Long id,Model model) {
		Article article=articleService.getArticleById(id);
		articleService.addReading(id);
		model.addAttribute("article", article);
		return new ModelAndView("/article");
	}
	
	@PostMapping("/zan/{id}")
	public String addArticle(HttpServletRequest request,@PathVariable("id") Long id) {		
		String callback=request.getParameter("callback");
		JsonData jsonData;
		articleService.addLikes(id);
		jsonData=new JsonData("200", "success", "点赞成功", callback);
		return jsonData.toString();
	}
}
