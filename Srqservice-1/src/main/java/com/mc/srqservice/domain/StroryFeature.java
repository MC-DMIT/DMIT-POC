package com.mc.srqservice.domain;

import java.util.List;

public class StroryFeature  {

	public String getFeatureId() {
		return featureId;
	}
	public void setFeatureId(String featureId) {
		this.featureId = featureId;
	}
	public List<SrqDomain> getSrqList() {
		return srqList;
	}
	public void setSrqList(List<SrqDomain> srqList) {
		this.srqList = srqList;
	}
	private String featureId;
	private List<SrqDomain> srqList;
}
