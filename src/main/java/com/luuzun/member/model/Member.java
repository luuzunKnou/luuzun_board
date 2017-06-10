package com.luuzun.member.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Member {
	public static final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

	private String memberId;
	private String memberName;
	private String memberPassword;
	private Date memberRegDate;
	
	public Member() {}
	
	public Member(String memberId, String memberPassword) {
		super();
		this.memberId = memberId;
		this.memberPassword = memberPassword;
	}

	public Member(String memberId, String memberName, String memberPassword, Date memberRegDate) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.memberPassword = memberPassword;
		this.memberRegDate = memberRegDate;
	}
	
	public String getMemberId() {
		return memberId;
	}
	
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberPassword() {
		return memberPassword;
	}
	
	public void setMemberPassword(String memberPassword) {
		this.memberPassword = memberPassword;
	}
	
	public Date getMemberRegDate() {
		return memberRegDate;
	}
	
	public String getMemberRegDateString(){
		return simpleDateFormat.format(memberRegDate);
	}
	
	public void setMemberRegDate(Date memberRegDate) {
		this.memberRegDate = memberRegDate;
	}
	
	@Override
	public String toString() {
		return String.format("Member [memberId=%s, memberName=%s, memberPassword=%s, memberRegDate=%s]", memberId,
				memberName, memberPassword, memberRegDate);
	}
}
