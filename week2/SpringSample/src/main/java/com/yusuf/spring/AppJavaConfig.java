package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.yusuf.spring.config.AppConfig;
import com.yusuf.spring.model.DisplayProduct;

public class AppJavaConfig {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		DisplayProduct bean = context.getBean("displayProduct", DisplayProduct.class);
		System.out.println(bean);
	}
}
