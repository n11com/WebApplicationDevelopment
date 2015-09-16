package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.Product;

public class AppDependencies {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		getAndPrintBean(context, "featuredProduct");
		getAndPrintBean(context, "featuredProduct2");
		getAndPrintBean(context, "featuredProduct3");
	}
	
	public static void getAndPrintBean(ApplicationContext context, String beanName){
		Product bean = context.getBean(beanName, Product.class);
		System.out.println(beanName + " - " + bean);
	}
}
