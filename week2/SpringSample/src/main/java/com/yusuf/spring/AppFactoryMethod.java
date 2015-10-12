package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;

/*
 * This example show you how to use factory methods to create bean instances
 * Find clientService bean in resources/beans.xml
 */
public class AppFactoryMethod {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

        /*
         * This bean instance will be created by calling the factory method "createInstance", not the constructor.
         * Also note that factory method needs to be static
         */
		ClientService bean = context.getBean("clientService", ClientService.class);
		System.out.println(bean);
	}
}
