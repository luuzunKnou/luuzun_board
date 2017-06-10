package com.luuzun.article.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.luuzun.member.model.Member;

public class Article {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
	
	private int articleNo;
	private Member writerId;
	private String title;
	private Date articleRegDate;
	private Date articleModDate;
	private int readCnt;

	public Article() {}

	public Article(int articleNo, Member writerId, String title, Date articleRegDate, Date articleModDate, int readCnt) {
		this.articleNo = articleNo;
		this.writerId = writerId;
		this.title = title;
		this.articleRegDate = articleRegDate;
		this.articleModDate = articleModDate;
		this.readCnt = readCnt;
	}

	public Article(Member writerId, String title, Date articleRegDate, Date articleModDate) {
		this.writerId = writerId;
		this.title = title;
		this.articleRegDate = articleRegDate;
		this.articleModDate = articleModDate;
	}

	public int getArticleNo() {
		return articleNo;
	}

	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}

	public Member getWriterId() {
		return writerId;
	}

	public void setWriterId(Member writerId) {
		this.writerId = writerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getArticleRegDate() {
		return articleRegDate;
	}

	public void setArticleRegDate(Date articleRegDate) {
		this.articleRegDate = articleRegDate;
	}

	public Date getArticleModDate() {
		return articleModDate;
	}
	
	public void setArticleModDate(Date articleModDate) {
		this.articleModDate = articleModDate;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	
	public String getWriterID(){
		return writerId.getMemberId();
	}
	
	public String getWriterName(){
		return writerId.getMemberName();
	}
	
	public String getArticleModDateString() {
		return simpleDateFormat.format(articleModDate);
	}
	
	public String getArticleRegDateString() {
		return simpleDateFormat.format(articleRegDate);
	}

	@Override
	public String toString() {
		return String.format(
				"Article [articleNo=%s, writerId=%s, title=%s, articleRegDate=%s, articleModDate=%s, readCnt=%s]",
				articleNo, writerId, title, articleRegDate, articleModDate, readCnt);
	}
}