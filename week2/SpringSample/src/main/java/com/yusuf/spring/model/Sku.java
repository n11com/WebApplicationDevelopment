package com.yusuf.spring.model;

public class Sku {

	private String name;
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Sku [name=" + name + "]";
	}
}
