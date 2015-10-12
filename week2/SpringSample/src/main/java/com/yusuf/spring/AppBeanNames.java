package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ExampleBean;

/*
 * This example show you how to get a bean reference from Spring.
 * Find bean1, bean2 and bean3 beans in resources/beans.xml
 */
public class AppBeanNames {
	public static void main(String[] args) {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

        // get the bean whose id is bean1
		getAndPrintBean(context, "bean1");

        // get the bean whose name is bean2
		getAndPrintBean(context, "bean2");

        // get the bean whose name is bean3
		getAndPrintBean(context, "bean3");

        /*
         * get the bean whose name is bean3Alias.
         * not that bean3 and bean3Alias are declared for the same bean,
         * so actually we should get the same bean instance
         */
		getAndPrintBean(context, "bean3Alias");
	}
	
	public static void getAndPrintBean(ApplicationContext context, String beanName){
		ExampleBean bean = context.getBean(beanName, ExampleBean.class);
		System.out.println(beanName + " - " + bean);
	}
}
