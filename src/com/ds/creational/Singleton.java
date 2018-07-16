package com.ds.creational;

import java.sql.Connection;

public class Singleton {
	
	private static volatile Singleton instance = null;
	private static volatile Connection connection = null;
	
	private Singleton() {
		
		// avoid reflection
		if(instance != null) {
			throw new RuntimeException("create object only with getInstance() method");
		}
	}
	
	public static Singleton getInstance() {
		if(instance == null) {
			synchronized (Singleton.class) {
				
				// double check with Thread Safe
				if(instance == null) {
				
					// lazy loading
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	
	
	Connection getConnection() {
		if(connection == null) {
			synchronized (Singleton.class) {
				if(connection == null) {
					// Create Database connection here
				}
				
			}
		}
		return connection;
	}
}