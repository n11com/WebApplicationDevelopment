package com.yusuf.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * This example show you how Spring calls appropriate methods of your beans in its lifecycle.
 * Find callbacks bean in resources/callbacks.xml.
 *
 * Also have a look at com.yusuf.spring.BeanPostProcessorExample class which is defined in callbacks.xml
 */
public class AppCallback {
	public static void main(String[] args) {
        // this reads the callbacks.xml file and starts up Spring Application Context
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "callbacks.xml" });

        /*
         * we don't do anything with the bean instance we get here.
         * This line is put here so that you understand when the methods are called.
         * @see com.yusuf.spring.model.BeansWithCallbacks
         */
		context.getBean("callbacks");

        /*
         * Generally you don't need to close the context,
         *  unless you want to be notified about when the beans are being destroyed
         *  @see com.yusuf.spring.BeanPostProcessorExample
         */
		context.close();
	}
}
