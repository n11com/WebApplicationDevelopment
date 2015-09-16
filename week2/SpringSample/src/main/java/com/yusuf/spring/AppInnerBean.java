package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.ExpensiveToCreateBean;

public class AppInnerBean {
	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		DisplayProduct bean = context.getBean("outer", DisplayProduct.class);
		System.out.println(bean);
		
		Thread.sleep(10000);
		
		context.getBean("lazy", ExpensiveToCreateBean.class);
		
	}
}
