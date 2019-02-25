package com.mc.srqservice.domain;

import java.util.List;

public class Feature {
	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	public List<UserStories> getUserStroryList() {
		return userStroryList;
	}
	public void setUserStroryList(List<UserStories> userStroryList) {
		this.userStroryList = userStroryList;
	}
	private String featureId;
	List<UserStories> userStroryList;
	
}
