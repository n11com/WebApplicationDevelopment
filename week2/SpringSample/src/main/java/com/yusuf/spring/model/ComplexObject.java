package com.yusuf.spring.model;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class ComplexObject {
	private Properties adminEmails;
	private List<String> someList;
	private Map<String, String> someMap;
	private Set<String> someSet;
	
	public void setAdminEmails(Properties adminEmails) {
		this.adminEmails = adminEmails;
	}
	public void setSomeList(List<String> someList) {
		this.someList = someList;
	}
	public void setSomeMap(Map<String, String> someMap) {
		this.someMap = someMap;
	}
	public void setSomeSet(Set<String> someSet) {
		this.someSet = someSet;
	}
	
	@Override
	public String toString() {
		return "ComplexObject [adminEmails=" + adminEmails + ", someList=" + someList + ", someMap=" + someMap
				+ ", someSet=" + someSet + "]";
	}
}
