package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.Product;

public class AppDependencies {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		Product bean = context.getBean("featuredProduct", Product.class);
		System.out.println(bean);
		
		bean = context.getBean("featuredProduct2", Product.class);
		System.out.println(bean);
	}
}
