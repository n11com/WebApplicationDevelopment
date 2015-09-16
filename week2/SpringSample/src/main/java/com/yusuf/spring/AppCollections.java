package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.ComplexObject;
import com.yusuf.spring.model.DisplayProduct;

public class AppCollections {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		ComplexObject bean = context.getBean("moreComplexObject", ComplexObject.class);
		System.out.println(bean);
	}
}
