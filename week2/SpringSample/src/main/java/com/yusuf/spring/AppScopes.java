package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.CustomerService;
import com.yusuf.spring.model.DisplayProduct;

/*
 * This example shows you how scopes works in Spring
 * Find customerService and prototypeCustomerService beans in resources/beans.xml
 */
public class AppScopes {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

        /*
         * All beans are, by default, singletons. That means whenever you request a beans instance from Spring,
         *  it will return the same instance.
         */
		System.out.println("==Single Scope==");
		getBeanAndProcess(context, "customerService");

        /*
         * If you mark a bean as prototype, a new instance will be created by the framework whenever we request
         *  a bean instance.
         */
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
