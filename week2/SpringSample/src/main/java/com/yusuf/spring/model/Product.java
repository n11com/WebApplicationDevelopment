package com.yusuf.spring.model;

public class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + "]";
	}
    
}