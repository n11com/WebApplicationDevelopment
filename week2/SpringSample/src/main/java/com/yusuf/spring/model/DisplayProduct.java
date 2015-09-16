package com.yusuf.spring.model;

public class DisplayProduct {
    private Sku variants;

	public void setVariants(Sku variants) {
		this.variants = variants;
	}

	@Override
	public String toString() {
		return "DisplayProduct [variants=" + variants + "]";
	}
	
}