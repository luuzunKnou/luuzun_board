package com.luuzun.member.model;

import java.sql.SQLException;
import java.util.List;

public interface MemberDao {
	public void insert(Member member) throws SQLException;
	public Member selectById(String memberId) throws SQLException;
	public List<Member> selectByAll() throws SQLException;
	public void delete(Member member) throws SQLException;
	public void update(Member member) throws SQLException;
	public void updatePassword(Member member);
}