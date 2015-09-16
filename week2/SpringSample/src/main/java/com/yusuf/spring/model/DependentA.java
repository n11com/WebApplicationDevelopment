package com.yusuf.spring.model;

public class DependentA {
	private DependentB dependencyB;
	
	public DependentA(DependentB dependencyB){
		this.dependencyB = dependencyB;
	}
}
