package com.luuzun.article.model;

import java.util.List;

import com.luuzun.member.model.Member;

public interface ArticleContentDao {
	public int insert(ArticleContent articleContent);
	public List<ArticleContent> selectByAll();
	public ArticleContent selectById(int articleNo);
	public int delete(int articleNo);
	public int update(ArticleContent articleContent);
}
