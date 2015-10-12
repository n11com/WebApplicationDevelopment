package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.ProductLister;
import com.yusuf.spring.scan.SampleComponent;

/*
 * This example show you how Spring enables us not to define any bean in XML file, but create them via annotaions.
 * Find component-scan definition in resources/componentScan.xml
 */
public class AppComponentScan {
	public static void main(String[] args) {
        /*
         * This reads the componentScan.xml file and starts up Spring Application Context
         *
         * componentScan.xml file contains context:component-scan tag which will configure Spring
         *  to scan all class files for specific annotations so that it can create bean instances automatically.
         *
         *  Since it would be time consuming to search all classes from all jar (jar files that resides
         *  in classpath), we specify a base package. Doing this will cause Spring to only inspect annotations
         *  for classes that are defined beneath base package.
         *
         *  In this example we have only one class in base package. Notice that no bean definition
         *  exists in xml file
         */
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "componentScan.xml" });

		SampleComponent bean = context.getBean("sampleComponent", SampleComponent.class);
		System.out.println(bean);
	}
}
