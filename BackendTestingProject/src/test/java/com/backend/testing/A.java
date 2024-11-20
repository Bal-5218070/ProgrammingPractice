package com.backend.testing;

public class A {
	/*
	 * public static void given() { System.out.println("execute given method"); }
	 * public static void when() { System.out.println("execute when method"); }
	 * public static void then() { System.out.println("execute then method"); }
	 */

	public A a() {
		System.out.println("execute mtd a");
		return new A();//it is going to return current class object reference
		
	}
	
	public A b() {
		System.out.println("execute mtd b");
		return new A();
		
	}
	
	public B c() {
		System.out.println("execute mtd c");
		return new B();
	}
}
