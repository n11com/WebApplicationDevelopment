package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.ExpensiveToCreateBean;

/*
 * This example shows you how to declare inner beans as properties to other beans
 * Find outer bean in resources/beans.xml
 */
public class AppInnerBean {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

        /*
         * Note that the dependency "variants" is declared by using an bean tag in property tag
         */
		DisplayProduct bean = context.getBean("outer", DisplayProduct.class);
		System.out.println(bean);
	}
}
