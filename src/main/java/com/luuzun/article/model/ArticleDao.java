package com.luuzun.article.model;

import java.util.List;

import com.luuzun.member.model.Member;

public interface ArticleDao {
	public int insert(Article article);
	public List<Article> selectByAll();
	public Article selectById(int articleNo); 
	public int delete(String memberId); 
	public int update(Member member);
	
	public int updateCount(int articleNo); 
	public int selectLastId();
}
