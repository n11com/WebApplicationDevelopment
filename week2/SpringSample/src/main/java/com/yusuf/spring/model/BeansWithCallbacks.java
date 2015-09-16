package com.yusuf.spring.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class BeansWithCallbacks implements InitializingBean, DisposableBean {

	public BeansWithCallbacks() {
		System.out.println("Constructor is called");
	}
	
	public void setDummy(String dummy){
		System.out.println("setter is called");
	}
	
	public void destroy() throws Exception {
		System.out.println("Destroy method is called");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("Initialized method is called");
	}
	
}
