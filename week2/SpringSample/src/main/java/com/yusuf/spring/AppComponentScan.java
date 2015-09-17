package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.ProductLister;
import com.yusuf.spring.scan.SampleComponent;

public class AppComponentScan {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "componentScan.xml" });

		SampleComponent bean = context.getBean("sampleComponent", SampleComponent.class);
		System.out.println(bean);
	}
}
