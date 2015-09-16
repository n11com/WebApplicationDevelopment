package com.yusuf.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppCallback {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });
		context.getBean("callbacks");
		
		context.close();
	}
}
