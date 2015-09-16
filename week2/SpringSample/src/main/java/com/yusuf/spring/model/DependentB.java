package com.yusuf.spring.model;

public class DependentB {
	private DependentA dependencyA;
	
	public DependentB(DependentA dependencyA){
		this.dependencyA = dependencyA;
	}
}
