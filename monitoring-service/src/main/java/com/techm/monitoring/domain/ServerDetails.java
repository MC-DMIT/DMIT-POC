package com.techm.monitoring.domain;

import lombok.Data;

@Data
public class ServerDetails {
	
	private String url;
	private int timeout;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getTimeout() {
		return timeout;
	}
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

}
