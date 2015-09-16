package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.CustomerService;
import com.yusuf.spring.model.DisplayProduct;

public class AppScopes {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		System.out.println("==Single Scope==");
		getBeanAndProcess(context, "customerService");
		
		System.out.println("==Prototype Scope==");
		getBeanAndProcess(context, "prototypeCustomerService");
	}

	private static void getBeanAndProcess(ApplicationContext context, String beanName) {
		CustomerService bean = context.getBean(beanName, CustomerService.class);
		bean.setMessage("First Message");
		System.out.println(bean.getMessage());
		
		CustomerService bean2 = context.getBean(beanName, CustomerService.class);
		System.out.println(bean2.getMessage());
	}
}
