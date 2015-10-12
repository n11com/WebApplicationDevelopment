package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.ProductLister;
/*
 * This example shows you how to inject dependencies into a bean using @Autowired annotation.
 * Find productLister bean in resources/beans.xml and see that no dependency is stated within the xml file.
 */
public class AppAnnotations {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		ProductLister bean = context.getBean("productLister", ProductLister.class);
		System.out.println(bean);
	}
}
