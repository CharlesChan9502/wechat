package com.charles.po;

import java.util.List;

public class NewsMessage extends BaseMessage{
	private String ArticleCount;
	private List<News> Articles;
	
	public String getArticleCount() {
		return ArticleCount;
	}
	public void setArticleCount(String articleCount) {
		ArticleCount = articleCount;
	}
	public List<News> getArticles() {
		return Articles;
	}
	public void setArticles(List<News> articles) {
		Articles = articles;
	}
	
	
}
