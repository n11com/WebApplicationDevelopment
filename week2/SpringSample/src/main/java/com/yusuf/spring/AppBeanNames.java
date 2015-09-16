package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppBeanNames {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		getAndPrintBean(context, "bean1");
		getAndPrintBean(context, "bean2");
		getAndPrintBean(context, "bean3");
		getAndPrintBean(context, "bean3Alias");
	}
	
	public static void getAndPrintBean(ApplicationContext context, String beanName){
		ExampleBean bean = context.getBean(beanName, ExampleBean.class);
		System.out.println(beanName + " - " + bean);
	}
}
