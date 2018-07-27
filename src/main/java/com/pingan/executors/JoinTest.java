package com.pingan.executors;

public class JoinTest {
	public static void main(String[] args) {
		try {
			System.out.println("aaa");
			System.out.println(Thread.currentThread().getName());
			Thread.currentThread().join();
			System.out.println("bbb");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
