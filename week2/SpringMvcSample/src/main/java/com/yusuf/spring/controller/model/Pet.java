package com.yusuf.spring.controller.model;

import java.io.Serializable;

public class Pet implements Serializable{
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}
}
