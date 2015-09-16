package com.yusuf.spring.model;

import org.springframework.beans.factory.annotation.Autowired;

public class ProductLister {
	@Autowired
	private DisplayProduct product;

	@Override
	public String toString() {
		return "ProductLister [product=" + product + "]";
	}
	
	
}
