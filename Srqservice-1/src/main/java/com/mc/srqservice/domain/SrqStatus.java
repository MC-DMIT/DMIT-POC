package com.mc.srqservice.domain;

import java.util.Map;

public class SrqStatus {

	private String name;
	Map<String, Integer> count;
	
	public Map<String, Integer> getCount() {
		return count;
	}
	public void setCount(Map<String, Integer> count) {
		this.count = count;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
