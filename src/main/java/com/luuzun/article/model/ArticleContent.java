package com.luuzun.article.model;

public class ArticleContent {
	private int number;
	private String content;
	public ArticleContent() {
		super();
	}
	
	public ArticleContent(int number, String content) {
		super();
		this.number = number;
		this.content = content;
	}

	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return String.format("ArticleContent [number=%s, content=%s]", number, content);
	}
}
