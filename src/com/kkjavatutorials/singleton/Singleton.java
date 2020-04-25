package com.kkjavatutorials.singleton;

import java.io.Serializable;

public class Singleton implements Serializable{

	private static final long serialVersionUID = 1808144385520819134L;
	private static Singleton INSTANCE = null;

	private Singleton() {

	}

	public static Singleton getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Singleton();
		}
		return INSTANCE;
	}
	
	public Object readResolve() {
		return getInstance();
	}
}
