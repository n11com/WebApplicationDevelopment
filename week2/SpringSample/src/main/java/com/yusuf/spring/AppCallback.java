package com.yusuf.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCallback {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "callbacks.xml" });
		context.getBean("callbacks");
		
		context.close();
	}
}
