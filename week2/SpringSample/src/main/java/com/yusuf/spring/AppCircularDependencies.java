package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.DependentA;

public class AppCircularDependencies {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "circularDependency.xml" });
		
		context.getBean("dependentA", DependentA.class);
	}
}
