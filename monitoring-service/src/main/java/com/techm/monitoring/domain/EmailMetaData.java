package com.techm.monitoring.domain;

import lombok.Data;

@Data
public class EmailMetaData {
	private String[] emailAddresses;
	private String from;
	private String subject;
	private String mailContents;
	public EmailMetaData() {
		super();
	}
	public EmailMetaData(String[] emailAddresses, String subject, String mailContents) {
		super();
		this.emailAddresses = emailAddresses;
		this.subject = subject;
		this.mailContents = mailContents;
	}
	public String[] getEmailAddresses() {
		return emailAddresses;
	}
	public void setEmailAddresses(String[] emailAddresses) {
		this.emailAddresses = emailAddresses;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMailContents() {
		return mailContents;
	}
	public void setMailContents(String mailContents) {
		this.mailContents = mailContents;
	}
}