package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;

public class AppLazy {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		DisplayProduct bean = context.getBean("outer", DisplayProduct.class);
		System.out.println(bean);
	}
}
