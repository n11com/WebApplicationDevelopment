package com.yusuf.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.Sku;

/*
 * @Configuration annotation tells Spring that this class is a configuration class and can be used as a replacement
 *  for XML configuration file. It allows us to create bean instances programmatically.
 */
@Configuration
public class AppConfig {

    /*
     * @Bean annotation allows configuration class to return bean instances.
     */
    @Bean
    public Product product() {
        return new Product();
    }
    
    @Bean
    public Sku sku(){
    	return new Sku();
    }

    /*
     * Notice how we requested the dependencies from the Spring.
     */
    @Bean
    public DisplayProduct displayProduct(Sku sku) {
        DisplayProduct product = new DisplayProduct();
        product.setVariants(sku);
		return product;
    }
}
