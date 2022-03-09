package com.sendemail.dto;

public class EmailDto {

	String mailFrom;
	String mailTo;
	String subject;
	String userName;
	String jwt;
	
	public EmailDto() {
	}
	
	public EmailDto(String mailFrom, String mailTo, String subject, String userName, String jwt) {
		super();
		this.mailFrom = mailFrom;
		this.mailTo = mailTo;
		this.subject = subject;
		this.userName = userName;
		this.jwt = jwt;
	}



	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}

	public String getMailTo() {
		return mailTo;
	}

	public void setMailTo(String mailTo) {
		this.mailTo = mailTo;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	
}
