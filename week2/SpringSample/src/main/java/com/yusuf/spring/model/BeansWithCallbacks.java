package com.yusuf.spring.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

/*
 * Since this class implements org.springframework.beans.factory.InitializingBean,
 *  Spring will notify the class when the instance is created and dependencies are
 *  injected, by using afterPropertiesSet method
 *
 * Since this class implements org.springframework.beans.factory.DisposableBean,
 *  Spring will notify the class when its instance is destroyed by the Spring
 *  Framework, by using destroy method
 */
public class BeansWithCallbacks implements InitializingBean, DisposableBean {

	public BeansWithCallbacks() {
		System.out.println("Constructor is called");
	}
	
	public void setDummy(String dummy){
		System.out.println("setter is called");
	}

    // This method will be called when instance is destroyed
	public void destroy() throws Exception {
		System.out.println("Destroy method is called");
	}

    // This method will be called when instance is initialized
	public void afterPropertiesSet() throws Exception {
		System.out.println("Initialized method is called");
	}
	
}
