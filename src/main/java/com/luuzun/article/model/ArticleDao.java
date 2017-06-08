package com.luuzun.article.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.luuzun.jdbc.JdbcUtil;
import com.luuzun.member.model.Member;

public class ArticleDao {
	private static ArticleDao dao = new ArticleDao();
	private ArticleDao(){}
	public static ArticleDao getInstance(){
		return dao;
	}

	/********************** CRUD ***********************/
	
	public int insert(Connection con, Article article) throws SQLException {
		String query = "INSERT INTO article	(writer_id, wirter_name, title, reg_date, mod_date) "
				+ "VALUES(?, ?, ?, ?, ?);";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Statement stmt = null;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, article.getId());
			pstmt.setString(2, article.getName());
			pstmt.setString(3, article.getTitle());
			pstmt.setTimestamp(4, new Timestamp(article.getRegDate().getTime()));
			pstmt.setTimestamp(5, new Timestamp(article.getModifiedDate().getTime()));
			int insertedCount = pstmt.executeUpdate();
			
			if(insertedCount > 0){
				String query2 = "select last_insert_id() from article";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query2);
				if(rs.next()){
					int newNo = rs.getInt(1);
					return newNo;
				}
			}
			return -1;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(pstmt);
		}
	}
	
	public List<Article> selectList(Connection con) throws SQLException {
		String query = "SELECT article_no, writer_id, wirter_name, title, "
				+ "reg_date, mod_date, read_cnt	FROM article;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(query);
			rs = pstmt.executeQuery();
			List<Article> articleList = new ArrayList<>();
			while (rs.next()) {
				Article article = new Article();
				article.setNumber(rs.getInt("article_no"));
				article.setId(rs.getString("writer_id"));
				article.setName(rs.getString("wirter_name"));
				article.setTitle(rs.getString("title"));
				article.setRegDate(new Date(rs.getTimestamp("reg_date").getTime()));
				article.setModifiedDate(new Date(rs.getTimestamp("mod_date").getTime()));
				article.setReadCount(rs.getInt("read_cnt"));
				articleList.add(article);
			}
			return articleList;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public Article selectArticleById(Connection con, int articleNo) throws SQLException {
		String query = "SELECT article_no, writer_id, wirter_name, title, "
				+ "reg_date, mod_date, read_cnt	FROM article "
				+ "WHERE article_no=?;";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			rs = pstmt.executeQuery();
			Article article = new Article();
			if (rs.next()) {
				article.setNumber(rs.getInt("article_no"));
				article.setId(rs.getString("writer_id"));
				article.setName(rs.getString("wirter_name"));
				article.setTitle(rs.getString("title"));
				article.setRegDate(new Date(rs.getTimestamp("reg_date").getTime()));
				article.setModifiedDate(new Date(rs.getTimestamp("mod_date").getTime()));
				article.setReadCount(rs.getInt("read_cnt"));
			}
			return article;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public int updateCount(Connection con, int articleNo) throws SQLException{
		PreparedStatement pstmt = null;
		String query = "UPDATE article SET read_cnt = read_cnt+1 WHERE article_no=?;";
		int res = -1;
		
		try {
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, articleNo);
			pstmt.executeUpdate();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return res;
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
