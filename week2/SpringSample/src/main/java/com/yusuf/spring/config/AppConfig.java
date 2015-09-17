package com.yusuf.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.Sku;

@Configuration
public class AppConfig {
	
    @Bean
    public Product product() {
        return new Product();
    }
    
    @Bean
    public Sku sku(){
    	return new Sku();
    }
    
    @Bean
    public DisplayProduct displayProduct(Sku sku) {
        DisplayProduct product = new DisplayProduct();
        product.setVariants(sku);
		return product;
    }
}
