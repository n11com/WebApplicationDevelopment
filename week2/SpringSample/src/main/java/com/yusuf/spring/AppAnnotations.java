package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.Product;
import com.yusuf.spring.model.ProductLister;

public class AppAnnotations {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		ProductLister bean = context.getBean("productLister", ProductLister.class);
		System.out.println(bean);
	}
}
