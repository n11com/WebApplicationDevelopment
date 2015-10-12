package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yusuf.spring.config.AppConfig;
import com.yusuf.spring.model.DisplayProduct;

/*
 * This example shows you how to use Java classes to configure Spring
 * @see com.yusuf.spring.config.AppConfig
 *
 * Note that you don't need an XML file if you use Java Config.
 */
public class AppJavaConfig {
	public static void main(String[] args) {
        // this runs AppConfig class and starts up Spring Application Context
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DisplayProduct bean = context.getBean("displayProduct", DisplayProduct.class);
		System.out.println(bean);
	}
}
