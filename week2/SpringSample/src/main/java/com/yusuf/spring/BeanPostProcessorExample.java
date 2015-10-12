package com.yusuf.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*
 * Since this class implements org.springframework.beans.factory.config.BeanPostProcessor,
 *  it is eligible to receive callbacks about the bean instances that are created
 */
public class BeanPostProcessorExample implements BeanPostProcessor {

    /*
     * This method will be called for every bean definition that its instance is created
     *  but dependencies are not injected yet.
     *
     *  Method should return the bean instance back. Note that you can return a new instance of the class or
     *   its subclass as long as the class signatures are compatible
     */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean " + beanName + " is about to be initialized");
		return bean;
	}

    /*
     * This method will be called for every bean definition that its dependencies are just injected.
     *
     *  Method should return the bean instance back. Note that you can return a new instance of the class or
     *   its subclass as long as the class signatures are compatible
     */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("Bean ''" + beanName + "'' created : " + bean.toString());
		return bean;
	}

}