package com.luuzun.article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luuzun.jdbc.JdbcUtil;
import com.luuzun.member.model.Member;
import com.mysql.jdbc.Statement;

public class ArticleContentDao {
	private static ArticleContentDao dao = new ArticleContentDao();
	private ArticleContentDao(){}
	public static ArticleContentDao getInstance(){
		return dao;
	}

	/********************** CRUD ***********************/
	
	public int insert(Connection con, ArticleContent articleContent) throws SQLException {
		String query = "INSERT INTO article_content (article_no, content) "
				+ "VALUES(?, ?);";
		PreparedStatement pstmt = null;
		
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleContent.getNumber());
			pstmt.setString(2, articleContent.getContent());
			int result = pstmt.executeUpdate();
		
			return result;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<ArticleContent> selectList(Connection con) throws SQLException {
		String query = "SELECT article_no, content FROM article_content;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			List<ArticleContent> articleContentList = new ArrayList<>();
			while (rs.next()) {
				ArticleContent articleContent = new ArticleContent();
				articleContent.setNumber(rs.getInt("article_no"));
				articleContent.setContent(rs.getString("content"));
				articleContentList.add(articleContent);
			}
			return articleContentList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public ArticleContent selectArticleContentById(Connection con, int articleNo) throws SQLException {
		String query = "SELECT article_no, content FROM article_content WHERE article_no=?;";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			ArticleContent articleContent = new ArticleContent();
			if (rs.next()) {
				articleContent.setNumber(rs.getInt("article_no"));
				articleContent.setContent(rs.getString("content"));
			}
			return articleContent;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public int delete(Connection con, String memberId) throws SQLException{
		String query = "DELETE FROM Member WHERE member_id=?;";
		PreparedStatement pstmt = null;
		int res = -1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
	}

	public int update(Connection con, Member member) throws SQLException{
		PreparedStatement pstmt = null;
		String query = "UPDATE Member SET member_name=?, member_password=?, member_reg_date=? WHERE member_id=?;";
		int res = -1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, member.getMemberName());
			pstmt.setString(2, member.getMemberPassword());
			//pstmt.setDate(3, member.getMemberRegDate());
			pstmt.setString(4, member.getMemberId());
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
	}
	
	public Member selectByID(Connection con, String memberId) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "SELECT member_id, member_name, member_password, member_reg_date "
				+ "FROM Member "
				+ "WHERE member_id=?;";

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, memberId);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				Member member = new Member();
				member.setMemberId(rs.getString("member_id"));
				member.setMemberName(rs.getString("member_name"));
				member.setMemberPassword(rs.getString("member_password"));
				member.setMemberRegDate(new Date(rs.getTimestamp("member_reg_date").getTime()));
				return member;
			}
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		return null;
	}

	public int updatePassword(Connection con, String memberId, String newPassword) throws SQLException {
		PreparedStatement pstmt = null;
		String query = "UPDATE Member SET member_password=? WHERE member_id=?;";
		int res = -1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, memberId);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
	}
}
