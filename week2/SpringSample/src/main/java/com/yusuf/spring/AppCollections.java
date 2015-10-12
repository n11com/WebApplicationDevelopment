package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.ComplexObject;
import com.yusuf.spring.model.DisplayProduct;

/*
 * This example show you how Spring injects collections by defining them in XML configuration file.
 * Find moreComplexObject beans in resources/beans.xml
 *
 * Notice that Spring can create Map, List, Set and Properties instances automatically
 */
public class AppCollections {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		ComplexObject bean = context.getBean("moreComplexObject", ComplexObject.class);
		System.out.println(bean);
	}
}
