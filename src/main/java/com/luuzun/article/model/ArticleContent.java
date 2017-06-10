package com.luuzun.article.model;

public class ArticleContent {
	private Article article;
	private String content;
	private String filePath;
	
	public ArticleContent() {}

	public ArticleContent(Article article, String content, String filePath) {
		super();
		this.article = article;
		this.content = content;
		this.filePath = filePath;
	}

	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	@Override
	public String toString() {
		return String.format("ArticleContent [article=%s, content=%s, filePath=%s]", article, content, filePath);
	}
}
