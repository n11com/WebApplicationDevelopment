package com.yusuf.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yusuf.spring.model.DependentA;

/*
 * This example show you how Spring behaves when there is a circular dependency.
 * Find dependentA and dependentB beans in resources/circularDependency.xml
 *
 * Note that dependentA depends on dependentB and dependentB depends on dependentA
 */
public class AppCircularDependencies {
	public static void main(String[] args) {
        // this reads the circularDependency.xml file and starts up Spring Application Context
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "circularDependency.xml" });

        /*
          * whenever we request to get dependentA, it should throw an exception saying that bean still could not
          * initialized (because of circular dependency)
          */
		context.getBean("dependentA", DependentA.class);
	}
}
