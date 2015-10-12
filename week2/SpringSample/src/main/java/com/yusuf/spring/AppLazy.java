package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.ClientService;
import com.yusuf.spring.model.DisplayProduct;
import com.yusuf.spring.model.ExpensiveToCreateBean;

/*
 * This example shows you how to mark beans as lazy.
 * Find lazy bean in resources/beans.xml
 */
public class AppLazy {
	public static void main(String[] args) throws Exception {
        // this reads the beans.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "beans.xml" });

		DisplayProduct bean = context.getBean("outer", DisplayProduct.class);
		System.out.println(bean);

        /*
         * Application sleeps here for 10 seconds, so that we can actually see when the instance of
         *  ExpensiveToCreateBean is created
         */
		Thread.sleep(10000);

        /*
         * Notice when the message in ExpensiveToCreateBean's constructor is printed
         */
		context.getBean("lazy", ExpensiveToCreateBean.class);
	}
}
